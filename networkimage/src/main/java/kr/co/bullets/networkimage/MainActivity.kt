package kr.co.bullets.networkimage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter
import kr.co.bullets.networkimage.ui.theme.ComposeComponentsTheme

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
//                    Greeting("Android")
//                }
                CoilEx()
            }
        }
    }
}

@Composable
fun CoilEx() {
    // 스텝 3: rememberImagePainter를 이용해 Image의 painter를 설정합니다.
    // (Compose 한국어 문서의 추천, but Deprecated)
    // 이미지 URI: https://raw.githubusercontent.com/Fastcampus-Android-Lecture-Project-2023/part4-chapter3/main/part-chapter3-10/app/src/main/res/drawable-hdpi/wall.jpg
    // remember: 파라미터의 내용들을 저장했다가 다시 @Composable이 재호출 될 때, 그것을 기억했다가 알려준다는 것 입니다.
//    val painter = rememberImagePainter(data = "https://github-production-user-asset-6210df.s3.amazonaws.com/117099209/245334276-ec4da51f-7b72-4e1e-9d73-749dc14fbc11.jpg")
//    Image(
//        painter = painter,
//        contentDescription = "엔텔로프 캐년"
//    )
    // 스텝 4: AsyncImage를 이용해봅니다. model에 주소를 적으면 됩니다.
    Column {
        AsyncImage(
            model = "https://github-production-user-asset-6210df.s3.amazonaws.com/117099209/245334276-ec4da51f-7b72-4e1e-9d73-749dc14fbc11.jpg",
            contentDescription = "엔텔로프 캐년"
        )
        AsyncImage(
            model = "https://github-production-user-asset-6210df.s3.amazonaws.com/117099209/245334276-ec4da51f-7b72-4e1e-9d73-749dc14fbc11.jpg",
            contentDescription = "엔텔로프 캐년"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeComponentsTheme {
        CoilEx()
    }
}