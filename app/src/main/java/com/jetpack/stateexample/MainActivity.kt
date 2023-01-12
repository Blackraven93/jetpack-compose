package com.jetpack.stateexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jetpack.stateexample.ui.theme.StateExampleTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StateExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    DemoScreen()
                }
            }
        }
    }
}

@Composable
fun DemoScreen() {

}

@Composable
fun MyTextField() {

    // getValue setValue 존재
    // var textState = remember { mutableStateOf("") }
    // var (textValue, setText) = remember { mutableStateOf("") }
    var textState by remember { mutableStateOf("") }

    // val onTextChange = { text : String -> textState.value = text }
    // val onTextChange = { text: String -> setText(text) }
    val onTextChange = {
        text : String -> textState = text
    }

    // TextField(value = textState.value, onValueChange = onTextChange)
    TextField(value = textState, onValueChange = onTextChange)

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    StateExampleTheme {
        DemoScreen()
    }
}