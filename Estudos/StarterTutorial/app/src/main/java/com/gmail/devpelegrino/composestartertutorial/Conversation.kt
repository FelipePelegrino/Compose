package com.gmail.devpelegrino.composestartertutorial

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.gmail.devpelegrino.composestartertutorial.ui.theme.ComposeStarterTutorialTheme


@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn {
        items(messages) { message ->
            MessageCard(message)
        }
    }
}

@Preview
@Composable
fun PreviewConversation() {
    ComposeStarterTutorialTheme {
        Conversation(SampleData.conversationSample)
    }
}

object SampleData {
    val conversationSample = listOf(
        Message(
            author = "Android",
            body = "Test... Test... Test..."
        ),
        Message(
            author = "Android",
            body = "Olá Jetpack Compose, vamos funcionar? Vamo ve o poder que você tem, é mais de 8000? Vegeta ficaria orgulhoso"
        ),
        Message(
            author = "Ciri",
            body = "Você chega com Yennefer à vila de Lofoten." +
                    "\nA vila ainda está de luto pela perda do ataque da Caçada Selvagem." +
                    "\nYennefer interrompe um ritual para perguntar sobre Ciri." +
                    "\nAs mulheres apontam você na direção de um jardim mágico onde um homem chamado Craven foi visto pela última vez."
        ),
        Message(
            author = "Geralt",
            body = "Ciri passou algum tempo com Craven, até a açada Selvagem atacar. Uma besta chamada Morkvarg vive no jardim, no entanto."
        ),
        Message(
            author = "Android",
            body = "Será que deu bom ?"
        ),
        Message(
            author = "Android",
            body = "Deu bom (:"
        ),
        Message(
            author = "Android",
            body = "Amando o compose <3"
        ),
        Message(
            "Lexi",
            "Test...Test...Test..."
        ),
        Message(
            "Lexi",
            """List of Android versions:
            |Android KitKat (API 19)
            |Android Lollipop (API 21)
            |Android Marshmallow (API 23)
            |Android Nougat (API 24)
            |Android Oreo (API 26)
            |Android Pie (API 28)
            |Android 10 (API 29)
            |Android 11 (API 30)
            |Android 12 (API 31)""".trim()
        ),
        Message(
            "Lexi",
            """I think Kotlin is my favorite programming language.
            |It's so much fun!""".trim()
        ),
        Message(
            "Lexi",
            "Searching for alternatives to XML layouts..."
        ),
        Message(
            "Lexi",
            """Hey, take a look at Jetpack Compose, it's great!
            |It's the Android's modern toolkit for building native UI.
            |It simplifies and accelerates UI development on Android.
            |Less code, powerful tools, and intuitive Kotlin APIs :)""".trim()
        ),
        Message(
            "Lexi",
            "It's available from API 21+ :)"
        ),
        Message(
            "Lexi",
            "Writing Kotlin for UI seems so natural, Compose where have you been all my life?"
        ),
        Message(
            "Lexi",
            "Android Studio next version's name is Arctic Fox"
        ),
        Message(
            "Lexi",
            "Android Studio Arctic Fox tooling for Compose is top notch ^_^"
        ),
        Message(
            "Lexi",
            "I didn't know you can now run the emulator directly from Android Studio"
        ),
        Message(
            "Lexi",
            "Compose Previews are great to check quickly how a composable layout looks like"
        ),
        Message(
            "Lexi",
            "Previews are also interactive after enabling the experimental setting"
        ),
        Message(
            "Lexi",
            "Have you tried writing build.gradle with KTS?"
        )
    )
}
