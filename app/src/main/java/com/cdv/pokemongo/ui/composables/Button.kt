package com.cdv.pokemongo.ui.composables
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CustomButton(text: String) {
    Button(onClick = {}, shape = RoundedCornerShape(20.dp))  {
        Text(text = text) // Use the parameter text instead of hardcoding "text"
    }
}

@Preview
@Composable
fun PreviewCustomButton() {
    CustomButton(text = "Play")
}
