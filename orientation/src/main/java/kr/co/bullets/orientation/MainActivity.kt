package kr.co.bullets.orientation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kr.co.bullets.orientation.ui.theme.ComposeComponentsTheme

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
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeComponentsTheme {
        Greeting("Android")
    }
}

/**
 * Android가 15년이나 된 시스템이라는 것을 이해할 필요가 있습니다.
 * 15년 전의 모바일 환경
 * 15년 전(2008년)에 만들어진 레거시 UI 코드와 API
 * 그동안 레거시가 많았고 제안이 많았습니다. 그래서 구글은 새로운 시스템을 만들어서 사용하기로 결정을 하였고,
 * 그것이 바로 Jetpack Compose입니다.
 * Jetpack Comose는 Android를 위한 현대적인 선언형 UI도구 키드 (2021년 7월 28일 런칭)
 *
 * Jetpack Compose란
 * 자바로 시작했기 때문에 코틀린에 최적화되어 있지 않음
 * 기본적인 형태는 코틀린 함수로 UI를 구성하게 되어 있음
 * @Composable이라는 어노테이션이 함수에 붙어있음
 * 상호작용
 *  컴포즈는 기존 앱과 상호작용 가능함
 *  View(기존의 레거시 View)들을 컴포즈 UI 안에 넣을 수 있고 컴포즈를 뷰(기존의 레거시 View) 안에 넣을 수 있음
 * 젯팩 통합
 *  Compose는 Jetpack과 통합되도록 설계됨
 *  Navigation, Paging, LiveData, Flow/RxJava, ViewModel, Hilt
 * 머터리얼
 *  머터리얼 디자인 컴포넌트와 테마를 제공
 *  아름다운 앱을 만들고 브랜드를 표현
 *  복잡한 XML을 다루지 않고 이해하기 쉽고 추적하기 쉬움
 * 코드 감소
 * 코드 추적 (같은 파일에서 작성)
 * 여러 XML 파일로 확장해야 했을 일을 단일한 Kotlin 파일 내에서 달성
 * 사용 및 유지관리가 쉽고 구현/확장/맞춤설정(커스텀)이 직관적인 stateless UI
 * 추론하는 동안 기억해야 하는 사항이 줄어들고 통제를 벗어나거나 제대로 이해하지 못하는 행동이 적어짐
 * light mode, dark mode를 신경 쓸 필요가 없음
 * preview(미리보기)
 * 만들고 싶은 것과 실제로 만드는 것 사이의 차이가 줄어들었다
 * 애니메이션을 Compose에서 쉽게 추가할 수 있
 * Compose 활용 사례
 *
 * 선언형 UI란
 *
 */