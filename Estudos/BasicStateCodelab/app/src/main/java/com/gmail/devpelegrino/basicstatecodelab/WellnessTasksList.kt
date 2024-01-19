package com.gmail.devpelegrino.basicstatecodelab

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

fun getWellnessTasks() = List(30) { i ->
    WellnessTask(
        id = i,
        label = "Task # $i"
    )
}

@Composable
fun WellnessTasksList(
    modifier: Modifier = Modifier,
    list: List<WellnessTask> = remember { getWellnessTasks() }
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(list) { task ->
            WellnessTaskItem(taskName = task.label)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WellnessTasksListPreview() {
    WellnessTasksList()
}