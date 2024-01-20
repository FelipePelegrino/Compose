package com.gmail.devpelegrino.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun WellnessScreen(modifier: Modifier = Modifier) {
    Column {
        var count by rememberSaveable { mutableStateOf(0) }
        WaterCounter(
            count = count,
            onCountChange = { count++ },
            modifier = modifier
        )

////         Don't do this!
//
//        val list = remember { mutableStateListOf<WellnessTask>() }
//
//        list.addAll(getWellnessTasks())

        val list = remember { getWellnessTasks().toMutableStateList() }
        WellnessTasksList(list = list, onCloseTask = { task -> list.remove(task) })
    }
}

@Preview(showBackground = true)
@Composable
fun WellnessScreenPreview() {
    WellnessScreen()
}

private fun getWellnessTasks() = List(30) { i ->
    WellnessTask(
        id = i,
        label = "Task # $i"
    )
}