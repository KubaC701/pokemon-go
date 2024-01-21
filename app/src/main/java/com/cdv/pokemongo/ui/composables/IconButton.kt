package com.cdv.pokemongo.ui.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cdv.pokemongo.R
import com.cdv.pokemongo.ui.theme.SecondaryColor

@Composable
fun AppIconButton(icon : Painter, alt: String) {
    IconButton(onClick = { /* do something */ },
        colors = IconButtonDefaults.iconButtonColors(
            containerColor = SecondaryColor),
        modifier = Modifier.size(64.dp))
    {
        Icon(icon, contentDescription = alt,
            Modifier.padding(8.dp))
    }
}

@Preview
@Composable
fun AppIconButtonPreview() {
    AppIconButton(painterResource (id = R.drawable.fishing_net) , alt = "Settings")
}