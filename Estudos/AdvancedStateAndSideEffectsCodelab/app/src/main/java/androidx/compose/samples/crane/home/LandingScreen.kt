/*
 * Copyright 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package androidx.compose.samples.crane.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.samples.crane.R
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.delay

private const val SplashWaitTime: Long = 2000

@Composable
fun LandingScreen(onTimeout: () -> Unit, modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

        /*
        * Esse remember, armazena sempre o último valor recebido da recomposição trigada para
        * armazenar a função onTimeout(). Assim caso em 10 recomposições, na recomposição 1 e 6
        * onTimeout mudou a sua função, o currentOnTimeout armazenará a função da 6 recomposição.
        * Ao terminar o delay, ele executará a função recebida na 6 recomposição, garantindo assim
        * o comportamento esperado.
        * */
        val currentOnTimeout by rememberUpdatedState(onTimeout)

        /*
        * Como minha key é uma constante UNIT (poderia ser true/false, 1, qualquer constante)
        * Esse efeito só será lançado uma única vez. Ou seja, independente quantas recomposições
        * ocorram, o LaunchedEffect só executará uma única vez na chamada da minha LandingScreen
        * Caso eu quisesse que em momentos específicos desse Composable, ele retrigasse o evento e
        * resetasse toda a chamada do bloco, precisaria informar uma Key que correspondesse a minha
        * lógica.
        * Como o bloco espera 2 segundos (poderia ser uma chamada ao banco local/sensores/api) pode
        * ocorrer alguma recomposição, para isso foi criado a variável currentOnTimeout. Explicação acima
        * */
        LaunchedEffect(key1 = Unit) {
            delay(SplashWaitTime)
            currentOnTimeout()
        }
        Image(painterResource(id = R.drawable.ic_crane_drawer), contentDescription = null)
    }
}

@Preview(showBackground = true)
@Composable
fun LandingScreenPreview() {
    LandingScreen(onTimeout = { })
}