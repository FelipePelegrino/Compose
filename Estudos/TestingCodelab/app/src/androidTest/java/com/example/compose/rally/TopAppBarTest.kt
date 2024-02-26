package com.example.compose.rally

import androidx.compose.ui.test.assertIsSelected
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
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

}