package com.example.compose.rally

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.assertIsSelected
import androidx.compose.ui.test.hasClickAction
import androidx.compose.ui.test.hasContentDescription
import androidx.compose.ui.test.hasParent
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.printToLog
import com.example.compose.rally.ui.components.RallyTopAppBar
import com.example.compose.rally.ui.theme.RallyTheme
import org.junit.Rule
import org.junit.Test

class TopAppBarTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun rallyTopAppBarTest() {
        val allScreens = RallyScreen.entries

        /*
        * Só pode fazer o setContent 1 vez por teste
        * Caso eu queira testar estilização/screenshot, precisamos definir o mesmo theme aplicado no app
        * */
        composeTestRule.setContent {
            RallyTheme {
                RallyTopAppBar(
                    allScreens = allScreens,
                    onTabSelected = {},
                    currentScreen = RallyScreen.Accounts
                )
            }
        }

        /*
        * Os testes em compose funcionam em forma de Semantic tree, baseado na UI tree que o compose
        * gera ao criar os componentes.
        * */
        composeTestRule
            .onNodeWithContentDescription(RallyScreen.Accounts.name)
            .assertIsSelected()
    }

    /*
    * Não funciona procurar por texto nesse caso pois o composable setou via clearAndSetSemantics
    * */
    @Test
    fun rallyTopAppBarTest_currentLabelExists() {
        val allScreens = RallyScreen.values().toList()
        composeTestRule.setContent {
            RallyTopAppBar(
                allScreens = allScreens,
                onTabSelected = { },
                currentScreen = RallyScreen.Accounts
            )
        }

        /*
        * Não tem ferramenta ainda para semantic tree (26/02/2024) então
        * iremos na raiz, utilizar a fun printToLog para ver a semantic tree gerada.
        * */
        composeTestRule.onRoot().printToLog("currentLabelExists")

        composeTestRule
//            .onNodeWithText(RallyScreen.Accounts.name.uppercase())
            .onNodeWithContentDescription(RallyScreen.Accounts.name)
            .assertExists()
    }

    /*
    * https://developer.android.com/jetpack/compose/testing-cheatsheet
    * */
    @Test
    fun rallyTopAppBarTest_currentLabelExists_UsingOnNodeMatchers() {
        val allScreens = RallyScreen.entries
        composeTestRule.setContent {
            RallyTopAppBar(
                allScreens = allScreens,
                onTabSelected = { },
                currentScreen = RallyScreen.Accounts
            )
        }

        composeTestRule
            .onNode(
                matcher = hasText(RallyScreen.Accounts.name.uppercase()) and
                        hasParent(
                            hasContentDescription(RallyScreen.Accounts.name)
                        ),
                useUnmergedTree = true
            )
            .assertExists()
    }

    @Test
    fun rallyTopAppBarTest_clickLabel_checkHasChanged() {
        val allScreens = RallyScreen.entries
        var currentState by mutableStateOf(RallyScreen.Overview)

        composeTestRule.setContent {
            RallyTopAppBar(
                allScreens = allScreens,
                onTabSelected = { currentState = it },
                currentScreen = RallyScreen.Accounts
            )
        }

        composeTestRule
            .onNode(
                matcher = hasContentDescription(RallyScreen.Accounts.name) and
                        hasClickAction()
            )
            .performClick()


        assert(currentState.name == RallyScreen.Accounts.name)
    }

}