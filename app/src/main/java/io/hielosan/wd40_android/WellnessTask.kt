package io.hielosan.wd40_android

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

data class WellnessTask(
    val id: Int,
    val label: String,
    var initialChecked: Boolean = false
) {
    // checked 상태가 Compose에서 UI 업데이트를 트리거
    var checked: Boolean by mutableStateOf(initialChecked)
}
