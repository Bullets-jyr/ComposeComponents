package kr.co.bullets.checkbox

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Checkbox
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kr.co.bullets.checkbox.ui.theme.ComposeComponentsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeComponentsTheme {
                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colors.background
//                ) {
//                    CheckBoxEx()
//                }
                CheckBoxEx()
            }
        }
    }
}

// Composable함수는 언제든지 다시 그려질 수 있고, 중단될 수도 있고, 여러 쓰레드에서 동시에 여러 Composable를 그릴 수 있습니다.
@Composable
fun CheckBoxEx() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        // 스텝 1: Checkbox를 만들어봅시다. checked 속성은 false
        // onCheckedChange는 비워둡시다.
//        Checkbox(checked = false, onCheckedChange = {})

        // 스텝 2: onCheckedChange에서 boolean 값 변수를 바꾸고
        // checked에서 그 값을 반영해봅시다. (잘 되지 않습니다.)
        // checked가 일반적인 primitive type일 경우 영향을 주지 않습니다.
        // 다시 그려지는 절차가 있을 경우에만 내용이 변경됩니다.
        // recomposition이 가능하려면 상태가 변경이 되어야합니다.
        // var checked = false가 상태는 아닙니다.
        // compose에서 상태라고 불리는 것은 mutableStateOf타입입니다.
//        var checked = false
//        Checkbox(
//            checked = checked,
//            onCheckedChange = {
//                checked = !checked
//            }
//        )

        // Creating a state object during composition without using remember
        // 스텝 3: boolean 대신 remember { mutableStateOf(false) }를
        // 사용하여 상태를 도입합시다. (value 프로퍼티를 이용해야 합니다.)
//        var checked = remember { mutableStateOf(false) }
//        Checkbox(
//            checked = checked.value,
//            onCheckedChange = {
//                checked.value = !checked.value
//            }
//        )

        // 위임된 속성
        // var checked by remember { mutableStateOf(false) }
        // 마치 checked가 프로퍼티 인 것 처럼 사용할 수 있습니다.
        // 스텝 4: delegated properties로 변경해봅시다.
//        var checked by remember { mutableStateOf(false) }
//        Checkbox(
//            checked = checked,
//            onCheckedChange = {
//                checked = !checked
//            }
//        )

        // 비구조화
        // 스텝 5: destruction(비구조화, 반구조화, 구조분해)으로 상태를 받아서 사용해봅시다.
        val (getter, setter) = remember { mutableStateOf(false) }
        Checkbox(
            checked = getter,
//            onCheckedChange = {
////                setChecked(!checked)
//                setChecked(it)
//            }
            onCheckedChange = setter
        )

        // Checkbox를 앞에 넣어주세요.
        Text(
            text = "프로그래머입니까?",
            modifier = Modifier.clickable {
                setter(!getter)
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeComponentsTheme {
        CheckBoxEx()
    }
}