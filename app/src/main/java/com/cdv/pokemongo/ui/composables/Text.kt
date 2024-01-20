package com.cdv.pokemongo.ui.composables

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CustomTextComponent(text: String) {
    Text(text = text)
}
@Preview

@Composable
fun Text() {
    Text(text = "Text")
}
