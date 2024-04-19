package com.ruyun.mark

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ruyun.mark.ui.theme.MarkTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MarkTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Column {
                            // 使用remember来记住状态，避免每次重新创建
                            val message: MutableState<String> = remember { mutableStateOf("") }
                            // 显示message的值
                            Text(text = message.value)
                            // 创建一个按钮，并设置点击事件来更新message的值
                            Button(onClick = { message.value = "Hello World" }) {
                                Text("点击我")
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MarkTheme {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Column {
                val message: MutableState<String> = remember { mutableStateOf("") }
                Text(text = message.value)
                Button(onClick = { message.value = "Hello World" }) {
                    Text("点击我")
                }
            }
        }
    }
}
