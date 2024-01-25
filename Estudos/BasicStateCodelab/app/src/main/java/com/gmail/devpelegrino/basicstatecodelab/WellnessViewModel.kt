package com.gmail.devpelegrino.basicstatecodelab

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

class WellnessViewModel : ViewModel() {

    private val _tasks = getWellnessTasks().toMutableStateList()
    val tasks: List<WellnessTask>
        get() = _tasks

    fun remove(item: WellnessTask) {
        _tasks.remove(item)
    }

    fun changeTaskChecked(item: WellnessTask, checked: Boolean) {
        _tasks.find { currentTask -> currentTask.id == item.id }?.let { currentTask ->
            currentTask.checked = checked
        }
    }


    private fun getWellnessTasks() = List(30) { i ->
        WellnessTask(
            id = i,
            label = "Task # $i"
        )
    }
}