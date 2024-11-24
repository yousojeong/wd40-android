package io.hielosan.wd40_android

import StatefulCounter
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

/**
 * 기본 화면
 */
@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    wellnessViewModel: WellnessViewModel = viewModel()
) {
    Column(modifier = modifier) {
        StatefulCounter()

        WellnessTasksList(
            list = wellnessViewModel.tasks,
            onCheckedTask = { task, checked ->
                wellnessViewModel.changeTaskChecked(task, checked)
            },
            onCloseTask = { task -> wellnessViewModel.remove(task) }
        )
    }
}
/*
리스트와 아벤트 처리 로직을 나눈 이유는 구조화된 단방향 데이터 흐름을 유지하고 컴포저블의 재사용성과 책임분리를 위함

단방향 데이터 흐름 유지
- List는 상태 데이터
    - tasks를 ViewModel에서 관리하고, 이 데이터는 UI에서 읽기 전용으로 내려줌
    - 이렇게 하면 상태는 항상 단방향으로 흐르며, 상태 변경은 viewModel에서만 이루어지므로 예측 가능성이 높아짐

- 이벤트 콜백은 데이터를 변경하는 업데이트 로직
    - 상태는 ViewModel에서 관리되고, UI는 ViewModel에 상태 변경 요청만 보냄
    - 읽기와 쓰기를 분리함으로써 데이터의 흐름이 명확해짐
*/