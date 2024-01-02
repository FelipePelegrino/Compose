package com.gmail.devpelegrino

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gmail.devpelegrino.ui.theme.BasicsCodelabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicsCodelabTheme {
                MyApp(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@Composable
fun MyApp(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.background
    ) {
        Greeting(
            firstText = "Composable chamado MyApp está chamando",
            secondText = "Linha de baixo"
        )
    }
}

@Composable
private fun Greeting(
    firstText: String,
    secondText: String,
    modifier: Modifier = Modifier
) {
    /*
    * Compose foi construído para simplificar trabalhos comuns no mundo android
    * como por exemplo mudar o cor de fundo, e ter uma cor de texto própria para a cor de fundo
    * É o que acontece nesse exemplo, ao utilizar colorScheme.primary, automaticamente os textos
    * são utilizados a cor colorScheme.onPrimary.
    * Pois os componentes bases são construídos sobre componentes fundamentais, esse seria um exemplo.
    * */
    Surface(color = MaterialTheme.colorScheme.primary) {
        Column(modifier = Modifier.padding(24.dp)) {
            Text(text = "Hello $firstText!")
            Text(text = "Hello $secondText!")
        }
    }

    /*
    * Já o modifier, aplica a organização, display ou comportamento em como meu elemento
    * deve se ser aplicado, DENTRO do layout pai
    * */
}

@Preview(showBackground = true)
@Composable
private fun GreetingPreview() {
    BasicsCodelabTheme {
        MyApp()
    }
}