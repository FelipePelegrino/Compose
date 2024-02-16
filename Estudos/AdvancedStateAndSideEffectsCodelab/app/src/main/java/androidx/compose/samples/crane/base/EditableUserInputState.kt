package androidx.compose.samples.crane.base

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

/*
* Os states que representavam o EditableUserInput como um compsable statefull, foram transcritos
* para essa clase centralizando a lógica dos estados daquele composable em uma classe única.
* É uma boa prática também a classe fornecer a implementação do remember para os Composables utilizarem.
* Por isso, é criado em um companion object, a implementação de um Saver, já que esse tipo de dado
* complexo não pode ser armazenado automaticamente em um rememberSaveable, precisamos dessa implementação
* para chamar o rememberSaveable e usufruir a sua utilidade de armazenar o valor em recriações de activity.
* */
class EditableUserInputState(private val hint: String, initialText: String) {

    var text by mutableStateOf(initialText)
        private set

    fun updateText(newText: String) {
        text = newText
    }

    val isHint: Boolean
        get() = text == hint

    companion object {
        val Saver: Saver<EditableUserInputState, *> = listSaver(
            save = { listOf(it.hint, it.text) },
            restore = {
                EditableUserInputState(
                    hint = it[0],
                    initialText = it[1],
                )
            }
        )
    }
}

/*
* É uma boa prática no mesmo arquivo que definimos o stateHolder de nossa UI, encapsular o estado
* em um método remember para ser consumido pelos composables
* */
@Composable
fun rememberEditableUserInputState(hint: String): EditableUserInputState =
    rememberSaveable(key = hint, saver = EditableUserInputState.Saver) {
        EditableUserInputState(hint, hint)
    }