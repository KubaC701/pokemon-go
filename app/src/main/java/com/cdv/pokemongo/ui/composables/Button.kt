package com.cdv.pokemongo.ui.composables
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CustomButton(
    text: String
    onClick: ()-> Unit,

) {
    Button(
        onClick = onClick,
        modifier = modifier.padding(8.dp)
        shape = RoundedCornerShape(20.dp),)  {
        Text(text = text)
        color // Use the parameter text instead of hardcoding "text"
    }
}

@Preview
@Composable
fun PreviewCustomButton() {
    CustomButton(text = "Button Text")
}
