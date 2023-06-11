package kr.co.bullets.surface

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kr.co.bullets.surface.ui.theme.ComposeComponentsTheme

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
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    // Surface: Material디자인의 기본적인 패턴
    // Material surface is the central metaphor in material design.
    // 특징
    // Color설정을 Surface로 하면, contentColor가 자동으로 설정됩니다.
    // 예를 들어서 contentColor가 설정되어 있지 않다고 한다면, surface 색상을 사용한 경우에
    // onSurface라는 색상으로 contentColor가 설정됩니다.
    // 그리고 background 설정이 있으면, onBackground라는 설정이 기본으로 됩니다.
    // 또한 뒤에 touch를 전달하지 않는 특징이 있습니다.
    // 예를 들어서 Surface아래에 그림이 있다고 가정한다면, 그림까지 touch가 전달되지 않습니다.
    // 요약한다면, Surface는 기본적으로 UI를 구축하는 기반이 된다라고 생각하면 됩니다.
//    Surface(
//        color = MaterialTheme.colors.surface,
//        modifier = Modifier.padding(5.dp)
//    ) {
//        Text(
//            text = "Hello $name!",
//            modifier = Modifier.padding(8.dp)
//        )
//    }

    // 스텝 1: Surface에 elevation을 설정합시다.
//    Surface(
//        modifier = Modifier.padding(5.dp),
//        elevation = 5.dp
//    ) {
//        Text(
//            text = "Hello $name!",
//            modifier = Modifier.padding(8.dp)
//        )
//    }

    // 스텝 2: border의 값을 설정해봅시다.
//    Surface(
//        border = BorderStroke(
//            width = 2.dp,
//            color = Color.Magenta
//        ),
//        modifier = Modifier.padding(5.dp),
//        elevation = 5.dp
//    ) {
//        Text(
//            text = "Hello $name!",
//            modifier = Modifier.padding(8.dp)
//        )
//    }

    // 스텝 3: Surface의 shape도 설정해봅시다.
//    Surface(
//        border = BorderStroke(
//            width = 2.dp,
//            color = Color.Magenta
//        ),
//        modifier = Modifier.padding(5.dp),
//        elevation = 10.dp,
//        shape = CircleShape
//    ) {
//        Text(
//            text = "Hello $name!",
//            modifier = Modifier.padding(8.dp)
//        )
//    }

    // 스텝 4: color를 지정합시다.
    // MaterialTheme.colors에서 primary, error,
    // background, surface, secondary 등을 지정해봅시다.
    // contentColor가 자동으로 선택됩니다.

    // color만 설정하고 contentColor를 설정하지 않으면,
    // color에 맞추어서 적당한 contentColor가 설정됩니다.

    // [예시]
    // primary > onPrimary가 contentColor로 설정됩니다.
    // error > onError가 contentColor로 설정됩니다.
    // secondary > onSecondary가 contentColor로 설정됩니다.

    // 즉, 정리를 하자면 color의 색상이 MaterialTheme안에 있는 설정이라고 한다면,
    // 거기에 맞춰서 contentColor가 on[Primary, Error, Secondary 등등...]의 색상으로 설정됩니다.
    // 다시 한마디로 요약하자면 짝맞춤!
    Surface(
        border = BorderStroke(
            width = 2.dp,
            color = Color.Magenta
        ),
        modifier = Modifier.padding(5.dp),
        elevation = 10.dp,
        shape = CircleShape,
        color = MaterialTheme.colors.error
    ) {
        Text(
            text = "Hello $name!",
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeComponentsTheme {
        Greeting("Android")
    }
}