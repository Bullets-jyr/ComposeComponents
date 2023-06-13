package kr.co.bullets.image

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import kr.co.bullets.image.ui.theme.ComposeComponentsTheme

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
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    Column {
        // 스텝 1: Image를 만들어봅시다.
        // painter 항목에 painterResource(id = R.drawable.wall)
        // contentDescription에 엔텔로프 캐년이라고 넣읍시다.
        Image(
            painter = painterResource(id = R.drawable.wall),
            contentDescription = "엔텔로프 캐년"
        )

        // Image

        // 스텝 2: 두 번째 Image를 만들어봅시다.
        // imageVector에 Icons.Filled.Settings를 설정해봅시다.
        Image(
            imageVector = Icons.Filled.Settings,
            contentDescription = "세팅"
        )

//        Image(
//            bitmap =,
//            contentDescription = ""
//        )

        // Image
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeComponentsTheme {
        Greeting()
    }
}