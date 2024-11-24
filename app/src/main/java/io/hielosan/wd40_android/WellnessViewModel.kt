package io.hielosan.wd40_android

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

class WellnessViewModel : ViewModel() {
    // _tasks 내부에서 변경
    // toMutableStateList() Compose 내부에서 변경 사항을 관찰할 수 있는 특별한 상태 리스트
    private val _tasks = getWellnessTasks().toMutableStateList()

    // read-only 외부(UI)에서 tasks를 읽기만 가능하게 설정
    val tasks: List<WellnessTask>
        get() = _tasks

    fun remove(item: WellnessTask) {
        _tasks.remove(item)
    }

    fun changeTaskChecked(item: WellnessTask, checked: Boolean) =
        _tasks.find { it.id == item.id }?.let { tasks ->
            tasks.checked = checked
        }
}

private fun getWellnessTasks() = List(30) { i ->
    WellnessTask(i, "Task # $i")
}