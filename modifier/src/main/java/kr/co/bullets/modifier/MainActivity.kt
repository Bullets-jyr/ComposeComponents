package kr.co.bullets.modifier

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kr.co.bullets.modifier.ui.theme.ComposeComponentsTheme

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
                    ModifierEx()
                }
            }
        }
    }
}

@Composable
fun ModifierEx() {
//    Button(onClick = {}) {
//        Icon(
//            imageVector = Icons.Filled.Search,
//            contentDescription = null
//        )
//        Spacer(
//            modifier = Modifier.size(ButtonDefaults.IconSpacing)
//        )
//        Text("Search")
//    }

    // 스텝 1: modifier에 Modifier.fillMaxSize()를 사용해봅시다.
//    Button(
//        onClick = {},
//        modifier = Modifier.fillMaxSize()
//    ) {
//        Icon(
//            imageVector = Icons.Filled.Search,
//            contentDescription = null
//        )
//        Spacer(
//            modifier = Modifier.size(ButtonDefaults.IconSpacing)
//        )
//        Text("Search")
//    }

    // 스텝 2: fillMaxSize대신 Modifier.height를 설정해봅시다.
//    Button(
//        onClick = {},
//        modifier = Modifier.height(100.dp)
//    ) {
//        Icon(
//            imageVector = Icons.Filled.Search,
//            contentDescription = null
//        )
//        Spacer(
//            modifier = Modifier.size(ButtonDefaults.IconSpacing)
//        )
//        Text("Search")
//    }

    // 스텝 3: modifier에 height와 width를 같이 설정해봅시다.
//    Button(
//        onClick = {},
//        modifier = Modifier.height(100.dp)
//            .width(200.dp)
//    ) {
//        Icon(
//            imageVector = Icons.Filled.Search,
//            contentDescription = null
//        )
//        Spacer(
//            modifier = Modifier.size(ButtonDefaults.IconSpacing)
//        )
//        Text("Search")
//    }

    // 스텝 4: size에 width와 height를 인자로 넣을 수도 있습니다.
//    Button(
//        onClick = {},
////        modifier = Modifier.size(200.dp, 200.dp)
//        modifier = Modifier.size(200.dp)
//    ) {
//        Icon(
//            imageVector = Icons.Filled.Search,
//            contentDescription = null
//        )
//        Spacer(
//            modifier = Modifier.size(ButtonDefaults.IconSpacing)
//        )
//        Text("Search")
//    }

    // 스텝 5: background를 설정해봅시다. (버튼에서는 되지 않음.)
    // Button에 되지 않으면 Text나 Icon에 지정해봅시다.
//    Button(
//        onClick = {},
//        // Button에서는 modifier를 이용해서 Button의 색상을 변경할 수 없습니다.
//        modifier = Modifier.size(200.dp).background(Color.Red)
//    ) {
//        Icon(
//            imageVector = Icons.Filled.Search,
//            contentDescription = null
//        )
//        Spacer(
//            modifier = Modifier.size(ButtonDefaults.IconSpacing)
//        )
//        Text("Search")
//    }

    // 스탭 6: colors 파라미터에 ButtonDefaults.buttonColors를
    // 넣어보세요. backgroundColor와 contentColor 프로퍼티를
    // 설정하세요.
//    Button(
//        colors = ButtonDefaults.buttonColors(
//            backgroundColor = Color.Magenta,
//            contentColor = Color.Cyan,
//        ),
//        onClick = {},
//        // Button에서는 modifier를 이용해서 Button의 색상을 변경할 수 없습니다.
//        // modifier = Modifier.size(200.dp).background(Color.Red)
//        modifier = Modifier.size(200.dp)
//    ) {
//        Icon(
//            imageVector = Icons.Filled.Search,
//            contentDescription = null
//        )
//        Spacer(
//            modifier = Modifier.size(ButtonDefaults.IconSpacing)
//        )
//        Text("Search")
//    }

    // 스텝 7: Button의 modifier에 padding을 추가해봅시다.
//    Button(
//        colors = ButtonDefaults.buttonColors(
//            backgroundColor = Color.Magenta,
//            contentColor = Color.Cyan,
//        ),
//        onClick = {},
//        // Button에서는 modifier를 이용해서 Button의 색상을 변경할 수 없습니다.
//        // modifier = Modifier.size(200.dp).background(Color.Red)
//        modifier = Modifier.size(200.dp).padding(30.dp)
//    ) {
//        Icon(
//            imageVector = Icons.Filled.Search,
//            contentDescription = null
//        )
//        Spacer(
//            modifier = Modifier.size(ButtonDefaults.IconSpacing)
//        )
//        Text("Search")
//    }

    // 스탭 8: Button에 enabled를 false로 설정하고, Text의
    // modifier에 clickable을 넣어봅시다.
//    Button(
//        colors = ButtonDefaults.buttonColors(
//            backgroundColor = Color.Magenta,
//            contentColor = Color.Cyan,
//        ),
//        onClick = {},
//        enabled = false,
//        // Button에서는 modifier를 이용해서 Button의 색상을 변경할 수 없습니다.
//        // modifier = Modifier.size(200.dp).background(Color.Red)
//        modifier = Modifier.size(200.dp).padding(30.dp)
//    ) {
//        Icon(
//            imageVector = Icons.Filled.Search,
//            contentDescription = null
//        )
//        Spacer(
//            modifier = Modifier.size(ButtonDefaults.IconSpacing)
//        )
//        Text(
//            "Search",
//            // Text에서만 클릭 이벤트를 처리합니다.
//            modifier = Modifier.clickable {  }
//        )
//    }

    // 스탭 9: Text의 modifier에 offset를 설정하고 x 파라미터를
    // 설정합니다.
    Button(
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Magenta,
            contentColor = Color.Cyan,
        ),
        onClick = {},
        // enabled = false,
        // Button에서는 modifier를 이용해서 Button의 색상을 변경할 수 없습니다.
        // 왜? Button은 backgroundColor, contentColor 두 가지 색상이 있기 때문입니다.
        // 따라서 colors 파라미터를 사용해서 색상을 변경해야합니다.
        // modifier = Modifier.size(200.dp).background(Color.Red)
        modifier = Modifier.size(200.dp).padding(30.dp)
    ) {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = null,
            modifier = Modifier.background(Color.Blue)
        )
        Spacer(
            modifier = Modifier.size(ButtonDefaults.IconSpacing)
                .background(Color.Blue)
        )
        Text(
            "Search",
            // Text에서만 클릭 이벤트를 처리합니다.
            // modifier = Modifier.clickable {  }
             modifier = Modifier.offset(x = 10.dp)
                 .background(Color.Blue)
            // modifier = Modifier.offset(y = 10.dp)
//            modifier = Modifier.offset(y = -10.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeComponentsTheme {
        ModifierEx()
    }
}