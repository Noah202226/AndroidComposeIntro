package com.example.composeintro

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeintro.ui.theme.ComposeIntroTheme

@Composable
fun Greeting(
    name: String,
    modifier: Modifier = Modifier,
    viewModel: GreetingViewModel
    ) {
    val state = viewModel.state.value
    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Hello $name!",
            modifier = modifier
                .padding(16.dp),
            fontSize = 40.sp
        )
        Text(text = state.message,
            fontSize = 35.sp,
        )

        Row(
            modifier = modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            Button(onClick = {
                viewModel.setMessage(true)
            }) {
                Text(text = "Fine")
            }
            Button(onClick = { viewModel.setMessage(false) }) {
                Text(text = "Bad")
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val viewModel = GreetingViewModel()
    ComposeIntroTheme {
        Greeting("Tim", viewModel = viewModel)
    }
}