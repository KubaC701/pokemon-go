package com.cdv.pokemongo.ui.composables
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Title(
    text: String,
    fontSize: Int = 20,
    fontWeight: FontWeight = FontWeight.Bold
) {
    Text(
        text = text,
        modifier = Modifier
            .padding(16.dp)
            .padding(top = 16.dp), // Add additional padding if needed
        fontSize = fontSize.sp,
        fontWeight = fontWeight
    )
}

@Preview
@Composable
fun PreviewTitle() {
    Title(text = "Title")
}