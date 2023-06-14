package kr.co.bullets.slotapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Checkbox
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kr.co.bullets.slotapi.ui.theme.ComposeComponentsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeComponentsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SlotEx()
                }
            }
        }
    }
}

// Slot API
// 어떤 @Composable함수가 다른 @Composable함수나 아니면 컴포넌트를 포함할 수 있게 되어있는 것을 Slop API라고 합니다.

// 스텝 1: `Row`를 `@Composable` 함수로 분리합시다.
// `checked`의 값, `Text`의 `text`를 인자로 전달합시다.
//@Composable
//fun CheckBoxWithText(checked: MutableState<Boolean>, text: String) {
//    Row(verticalAlignment = Alignment.CenterVertically) {
//        Checkbox(
//            checked = checked.value,
//            onCheckedChange = { checked.value = it }
//        )
//        Text(
//            text = text,
//            modifier = Modifier.clickable { checked.value = !checked.value }
//        )
//    }
//}

// 스텝 2: `@Composable` 함수에서 `@Composable () -> Unit` 타입으로
// `content`를 받아옵시다. `Row`의 `Text`를 뺴고 `content()`를 넣읍시다.
// `Row`에 `Modifier.clickable`를 넣어 전체를 클릭가능하게 합시다.
//@Composable
//fun CheckBoxWithSlot(
//    checked: MutableState<Boolean>,
////    text: String,
//    content: @Composable () -> Unit) {
//    Row(
//        verticalAlignment = Alignment.CenterVertically,
//        modifier = Modifier.clickable {
//            checked.value = !checked.value
//        }
//    ) {
//        Checkbox(
//            checked = checked.value,
//            onCheckedChange = { checked.value = it }
//        )
////        Text(
////            text = text,
////            modifier = Modifier.clickable { checked.value = !checked.value }
////        )
//        content()
//    }
//}

// 스텝 3: `content`의 타입을 `@Composable RowScope.() -> Unit`로
// 바꿉시다. 이렇게 다른 콤포저블 컨텐트를 넣는 방식을 Slot API라 합니다.
//@Composable
//fun CheckBoxWithSlot(
//    checked: MutableState<Boolean>,
////    text: String,
//    // 외부에서 RowScope 이점을 활용하기 위한 설정 ColumnScope도 설정 가능
//    content: @Composable RowScope.() -> Unit) {
//    Row(
//        verticalAlignment = Alignment.CenterVertically,
//        modifier = Modifier.clickable {
//            checked.value = !checked.value
//        }
//    ) {
//        Checkbox(
//            checked = checked.value,
//            onCheckedChange = { checked.value = it }
//        )
////        Text(
////            text = text,
////            modifier = Modifier.clickable { checked.value = !checked.value }
////        )
//        content()
//    }
//}

// 스텝 4: 상태를 바꾸는 람다를 `@Composable` 함수의 인자로 뺍시다.
// 인자에서 MutableState대신 boolean 값으로 변경합시다.
@Composable
fun CheckBoxWithSlot(
//    checked: MutableState<Boolean>,
    checked: Boolean,
    onCheckedChanged: () -> Unit,
//    text: String,
    // 외부에서 RowScope 이점을 활용하기 위한 설정 ColumnScope도 설정 가능
    content: @Composable RowScope.() -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable {
            onCheckedChanged()
        }
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = { onCheckedChanged() }
        )
//        Text(
//            text = text,
//            modifier = Modifier.clickable { checked.value = !checked.value }
//        )
        content()
    }
}

@Composable
fun SlotEx() {
//    val checked1 = remember { mutableStateOf(false) }
//    val checked2 = remember { mutableStateOf(false) }

    // 위임된 프로퍼티
    var checked1 by remember { mutableStateOf(false) }
    var checked2 by remember { mutableStateOf(false) }

    Column {
//        Row(verticalAlignment = Alignment.CenterVertically) {
//            Checkbox(
//                checked = checked1.value,
//                onCheckedChange = { checked1.value = it }
//            )
//            Text(
//                text = "텍스트 1",
//                modifier = Modifier.clickable { checked1.value = !checked1.value }
//            )
//        }

//        Row(verticalAlignment = Alignment.CenterVertically) {
//            Checkbox(
//                checked = checked2.value,
//                onCheckedChange = { checked2.value = it }
//            )
//            Text(
//                text = "텍스트 2",
//                modifier = Modifier.clickable { checked2.value = !checked2.value }
//            )
//        }

//        CheckBoxWithText(checked1, "텍스트 1")
//        CheckBoxWithText(checked2, "텍스트 2")

//        CheckBoxWithSlot(checked1) {
//            Text(
//                text = "텍스트 1",
//                modifier = Modifier.align(Alignment.CenterVertically)
//            )
//        }
//        CheckBoxWithSlot(checked2) {
//            Text(
//                text = "텍스트 2",
//            )
//        }
        CheckBoxWithSlot(
            checked = checked1,
            onCheckedChanged = {
                checked1 = !checked1
            }) {
            Text(
                text = "텍스트 1",
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }
        CheckBoxWithSlot(
            checked = checked2,
            onCheckedChanged = {
                checked2 = !checked2
            }
        ) {
            Text(
                text = "텍스트 2",
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeComponentsTheme {
        SlotEx()
    }
}