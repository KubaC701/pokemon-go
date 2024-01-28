package com.cdv.pokemongo.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cdv.pokemongo.ui.theme.TertiaryColor

@Composable
fun Title(
    text: String,
    modifier: Modifier = Modifier,
    fontSize: Int = 36,
) {
    Box(
        modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(TertiaryColor)
            .padding(0.dp, 16.dp), contentAlignment = Alignment.Center

    ) {
        Text(text = text, fontSize = fontSize.sp, fontWeight = FontWeight.Bold)
    }
}

@Preview
@Composable
fun PreviewTitle() {
    Title(text = "Title")
}