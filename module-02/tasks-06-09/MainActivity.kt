package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .systemBarsPadding()
                ) {
//                    Circle_1()
//                    Circle_2()
//
//                    TextInfo_1()
//                    TextInfo_2()
//                    TextInfo_3()

                    WaterTracker()
                }
            }
        }
    }
}

@Preview(
    device = "spec:parent=pixel_7_pro,orientation=portrait",
    showSystemUi = true
)
@Composable
fun Circle_1() {
    MaterialTheme {
        Box(
            contentAlignment = Alignment.TopEnd,
            modifier = Modifier
                .systemBarsPadding()
                .size(240.dp, 120.dp)
                .background(Color.Black)
        ) {
            Image(
                painter = painterResource(R.drawable.circle),
                contentDescription = "Красный круг",
            )
        }
    }
}

@Preview(
    device = "spec:parent=pixel_7_pro,orientation=portrait",
    showSystemUi = true
)
@Composable
fun Circle_2() {
    MaterialTheme {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .systemBarsPadding()
                .size(240.dp, 120.dp)
                .background(Color.Blue)
        ) {
            Image(
                painter = painterResource(R.drawable.circle),
                contentDescription = "Фиолетовый овал",
                contentScale = ContentScale.FillBounds,
                colorFilter = ColorFilter.tint(Color(0xFF800080)),
                modifier = Modifier.fillMaxSize(),
            )
        }
    }
}

@Preview(
    device = "spec:parent=pixel_7_pro,orientation=portrait",
    showSystemUi = true
)
@Composable
fun TextInfo_1() {
    MaterialTheme {
        Column(
            modifier = Modifier.systemBarsPadding()
        ) {
            Text("Имя: Евгений")
            Text("Отчество: Андреевич")
            Text("Фамилия: Лукашин")
            Text("Мобильный телефон: +7 495 495 95 95")
            Text("Адрес: г. Москва, 3-я улица Строителей, д. 25, кв. 12")
        }
    }
}

@Composable
fun ContactBlock(text: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .padding(8.dp)
    ) {
        Text(
            text = text,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(
    device = "spec:parent=pixel_7_pro,orientation=portrait",
    showSystemUi = true
)
@Composable
fun TextInfo_2() {
    val text_1 = """
        Имя: Евгений
        Отчество: Андреевич
        Фамилия: Лукашин
        Мобильный телефон: +7 495 495 95 95
        Адрес: г. Москва, 3-я улица Строителей, д. 25, кв. 12
    """.trimIndent()

    val text_2 = """
        Имя: Василий
        Отчество: Егорович
        Фамилия: Кузякин
        Мобильный телефон: —
        Адрес: Ивановская область, дер. Крутово, д. 4
    """.trimIndent()

    val text_3 = """
        Имя: Людмила
        Отчество: Прокофьевна
        Фамилия: Калугина
        Мобильный телефон: +7 495 788 78 78
        Адрес: Москва, Большая Никитская, д. 43, кв. 290
    """.trimIndent()

    MaterialTheme {
        Column(
            modifier = Modifier
                .systemBarsPadding()
                .fillMaxWidth()
                .padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            ContactBlock(text_1)
            ContactBlock(text_2)
            ContactBlock(text_3)
        }
    }
}

@Preview(
    device = "spec:parent=pixel_7_pro,orientation=portrait",
    showSystemUi = true
)
@Composable
fun TextInfo_3() {
    val text = """
        Имя: Евгений
        Отчество: Андреевич
        Фамилия: Лукашин
        Мобильный телефон: +7 495 495 95 95
        Адрес: г. Москва, 3-я улица Строителей, д. 25, кв. 12
    """.trimIndent()

    MaterialTheme {
        Row(
            modifier = Modifier
                .systemBarsPadding()
                .fillMaxWidth()
                .padding(8.dp)
                .background(Color.LightGray),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier.weight(1f),
            ) {
                ContactBlock(text)
            }

            Image(
                painter = painterResource(R.drawable.circle),
                contentDescription = "Изображение контакта",
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Preview(
    device = "spec:parent=pixel_7_pro,orientation=portrait",
    showSystemUi = true
)
@Composable
fun WaterTracker() {
    val primaryColor = Color.Blue
    val secondaryColor = Color.Black
    val buttonTextColor = Color.White

    var waterCount by remember { mutableStateOf(0) }
    var dayCount by remember { mutableStateOf(0) }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Трекер воды",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = primaryColor
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Количество дней: $dayCount",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = secondaryColor,
            modifier = Modifier.testTag("Count_days_text")
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "$waterCount мл",
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold,
            color = secondaryColor,
            modifier = Modifier.testTag("Value_text")
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = primaryColor,
                contentColor = buttonTextColor
            ),
            onClick = { waterCount += 250 }
        ) {
            Text(
                text = "+250 мл",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = primaryColor,
                contentColor = buttonTextColor
            ),
            onClick = {
                if (waterCount >= 1500) dayCount++
                else dayCount = 0
                waterCount = 0
            }
        ) {
            Text(
                text = "Завершить день",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
