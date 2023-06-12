package kr.co.bullets.box

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kr.co.bullets.box.ui.theme.ComposeComponentsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeComponentsTheme {
                // A surface container using the 'background' color from the theme
                // Surface는 최소 사이즈 제약을 전파하는 특성이 있습니다.
                // Surface가 실제로는 Box로 되어 있고 propagateMinConstraints를 설정한게 보이죠.
                // propagateMinConstraints를 true로 설정했기 때문에 Surface의 자식들에게는 최소 사이즈 제약이 전파됩니다.
                // 그래서 Surface에 설정한 fillMaxSize가 영향을 미치고 있는 거죠.
                // 해법은 몇가지가 있을 수 있겠는데요.
                // 1. Surface를 제외해서 propagateMinConstraints의 영향을 미치지 않게 한다. (이건 경우에 따라 Surface를 쓰고 싶을 수 있으니 답이 아닐 수 있겠죠.)
                // 2. Surface와 Button사이에 다른 레이아웃을 넣어서 제약이 끊어지게 하는 것입니다.
                //    예를 들어 중간에 Box를 넣으면 Surface에 설정된 최소 사이즈 제약이 Button까지 내려오지 못할거에요.
                // https://issuetracker.google.com/issues/177726827?pli=1#comment8
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colors.background
//                ) {
//                    BoxEx()
//                }
                BoxEx()
            }
        }
    }
}

@Composable
fun BoxEx() {
    // [용도]
    // 1. Box자체를 만들기 위해서
    // 2. 안드로이드 프레임워크에 있는 FrameLayout과 같이 중첩시키는 용도로
//    Box(modifier = Modifier.size(100.dp)) {
//        Text(text = "Hello World", modifier = Modifier.align(Alignment.Center))
//    }
    // 스텝 1: Text 두개를 Box 안에 배치해봅시다.
//    Box(modifier = Modifier.size(100.dp)) {
//        Text(text = "Hello World", modifier = Modifier.align(Alignment.BottomEnd))
//        Text(text = "Jetpack", modifier = Modifier.align(Alignment.CenterEnd))
//        Text(text = "Compose", modifier = Modifier.align(Alignment.TopStart))
//    }

    // 스텝 2: 2개의 Box를 Box 안에 배치하고 사이즈를 70dp, 색상을 각기 다르게 해봅시다.
//    Box(modifier = Modifier.size(100.dp)) {
//        Box(modifier = Modifier.size(70.dp).background(Color.Cyan).align(Alignment.CenterStart))
//        Box(modifier = Modifier.size(70.dp).background(Color.Yellow).align(Alignment.BottomEnd))
//    }

    // 스텝 3: 부모 Box에 modifier 설정을 제거해서 콘텐트 사이즈만큼 보여주게 합시다.
    // 그리고 첫번째 자식 Box의 사이즈를 matchParentSize()로 설정해봅시다.
    // 다음에는 fillMaxSize()로 설정해봅시다.
    Box {
        Box(modifier = Modifier.fillMaxSize().background(Color.Cyan).align(Alignment.CenterStart))
        Box(modifier = Modifier.size(70.dp).background(Color.Yellow).align(Alignment.Center))
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeComponentsTheme {
        BoxEx()
    }
}