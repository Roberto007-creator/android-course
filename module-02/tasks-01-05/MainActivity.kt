package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
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
//                     Hello("Robert")
//                     Hello(null)
//
//                     Task3Texts()
//
//                     Task4Button()
                     Task5Initials("РТ")
                }
            }
        }
    }
}

@Composable
fun Hello(name: String?) {
    val text: String
    if (name == null) {
        text = "Имя не задано"
    } else {
        text = "Hello, ${name}!"
    }
    Text(
        text = text,
        fontSize = 32.sp,
        modifier = Modifier.padding(top = 40.dp)
    )
}

@Preview(
    name = "portrait",
    device = "spec:parent=pixel_7_pro,orientation=portrait",
    showSystemUi = true
)
@Preview(
    name = "landscape",
    device = "spec:parent=pixel_7_pro,orientation=landscape",
    showSystemUi = true
)
@Preview(
    name = "round",
    device = "spec:width=200dp,height=200dp,isRound=true",
    backgroundColor = 0xFFFFEB3B,
    showBackground = true,
    showSystemUi = true
)
@Composable
fun HelloPreview() {
    MaterialTheme {
        Hello("Robert")
    }
}

@Composable
fun Task3Texts() {
    val text = stringResource(R.string.jetpack_compose_desc)
    Column {
        Text(
            text = text,
            color = Color.Green,
            fontSize = 16.sp,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        Text(
            text = text,
            color = Color.Black,
            fontSize = 16.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.fillMaxWidth()
        )

        Text(
            text = text,
            color = Color.Black,
            fontSize = 24.sp,
            textDecoration = TextDecoration.Underline,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 48.dp)
                .background(Color.Green)
        )
    }
}

@Preview(
    name = "Task 3",
    showBackground = true,
)
@Composable
fun Task3Preview() {
    MaterialTheme {
        Task3Texts()
    }
}

@Composable
fun Task4Button() {
    Button(
        onClick = {},
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(2.dp, Color.Gray),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 4.dp
        ),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.LightGray,
            contentColor = Color.Black
        )
    ) {
        Text(text = "Нажми на меня")
    }
}

@Preview(
    name = "Task 4",
    showBackground = true,
)
@Composable
fun Task4Preview() {
    MaterialTheme {
        Task4Button()
    }
}

@Composable
fun Task5Initials(initials: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(Color.LightGray)
            .padding(top = 16.dp, bottom = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .aspectRatio(1f)
                .background(
                    color = Color(0xFFFF5722),
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = initials,
                color = Color.Black,
                fontSize = 16.sp
            )
        }
    }
}

@Preview(
    name = "Task 5",
    showBackground = true,
)
@Composable
fun Task5Preview() {
    MaterialTheme {
        Task5Initials("РТ")
    }
}
