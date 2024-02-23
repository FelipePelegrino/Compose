package com.example.compose.rally.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.compose.rally.Accounts
import com.example.compose.rally.Bills
import com.example.compose.rally.Overview
import com.example.compose.rally.SingleAccount
import com.example.compose.rally.ui.accounts.AccountsScreen
import com.example.compose.rally.ui.accounts.SingleAccountScreen
import com.example.compose.rally.ui.bills.BillsScreen
import com.example.compose.rally.ui.overview.OverviewScreen

/*
* Boa pratica separa o NavHost em um composable a parte que compõe o meu Compose top level
* */
@Composable
fun RallyNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Overview.route,
        modifier = modifier
    ) {
        /*
        * Primeira tela instanciada no meu NavGraph. Logo, as outras telas principais do app
        * Assim criamos o navGraph do app, vinculando tela e route.
        * */
        composable(route = Overview.route) {
            OverviewScreen(
                onAccountClick = { accountType ->
                    navController.navigateToSingleAccount(accountType)
                },
                onClickSeeAllAccounts = {
                    navController.navigateSingleTopTo(Accounts.route)
                },
                onClickSeeAllBills = {
                    navController.navigateSingleTopTo(Bills.route)
                }
            )
        }
        composable(route = Accounts.route) {
            AccountsScreen(
                onAccountClick = { accountType ->
                    navController.navigateToSingleAccount(accountType)
                }
            )
        }
        composable(route = Bills.route) {
            BillsScreen()
        }
        /*
        * Navigation with args - Obriga passar argumento quando chamar essa rota se não F
        * A rota/argument define a obrigatoriedade, é um contrato
        * Arguments, define o nome e o tipo
        * ---
        * DeepLinks: Aceita facilmente uma lista de deepLinks implicitos
        * Deeplinks serão instanciados no formato: scheme://route/arguments
        * Exemplo: rally://single_account/Checking
        * */
        composable(
            route = SingleAccount.routeWithArgs,
            arguments = SingleAccount.arguments,
            deepLinks = SingleAccount.deepLinks
        ) { navBackStackEntry ->
            /*
            * Pegando o valor passado para essa rota, no seu arguments, e passando o
            * composable que será instanciado.
            * */
            val accountType =
                navBackStackEntry.arguments?.getString(SingleAccount.accountTypeArg)

            SingleAccountScreen(accountType)
        }
    }
}

fun NavHostController.navigateSingleTopTo(route: String) =
    this.navigate(route) { launchSingleTop = true }

private fun NavHostController.navigateToSingleAccount(accountType: String) {
    this.navigateSingleTopTo("${SingleAccount.route}/$accountType")
}