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
fun ChangeProfileButton(icon : Painter, alt: String, onClick:()->Unit ) {
    IconButton(onClick = onClick,
        modifier = Modifier.size(64.dp))
    {
        Icon(icon, contentDescription = alt,
            Modifier.padding(8.dp), tint = SecondaryColor)

    }
}

@Preview
@Composable
fun ChangeProfileButtonPreview() {
    ChangeProfileButton(painterResource (id = R.drawable.next_button), alt = "Settings", onClick = {})
}