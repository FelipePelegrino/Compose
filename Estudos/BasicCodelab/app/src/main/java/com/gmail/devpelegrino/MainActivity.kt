package com.gmail.devpelegrino

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
fun MyApp(
    names: List<String> = listOf("Compose", "Kotlin"),
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.background
    ) {
        Column(Modifier.padding(vertical = 4.dp)) {
            for (name in names) {
                Greeting(name = name)
            }
        }
    }
}

/*
* Diferentes objetos Greeting em tela, são UI diferentes, que contem valores unicos em suas
* variáveis de estados.
* */
@Composable
private fun Greeting(name: String, modifier: Modifier = Modifier) {
    // internal state  = private variable
    // Precisamos do remember, para guardar a informação durante a recomposition
    val expanded = remember { mutableStateOf(false) }
    val extraPadding = if (expanded.value) 48.dp else 0.dp

    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        /*
        * atributo weight pega o maior valor de um composable, e empurra os demais componentes
        * até o necessário para eles serem exibidos.
        * */
        Row(modifier = Modifier.padding(24.dp)) {
            Column(modifier = Modifier
                .weight(1f)
                .padding(bottom = extraPadding)) {
                Text(text = "Hello ")
                Text(text = name)
            }
            ElevatedButton(
                onClick = {
                    expanded.value = !expanded.value
                }
            ) {
                if (expanded.value) Text("Show less") else Text("Show more")
            }
        }
    }
    /*
    * Já o modifier, aplica a organização, display ou comportamento em como meu elemento
    * deve se ser aplicado, DENTRO do layout pai
    * */
}

@Preview(showBackground = true, widthDp = 320)
@Composable
private fun GreetingPreview() {
    BasicsCodelabTheme {
        MyApp()
    }
}