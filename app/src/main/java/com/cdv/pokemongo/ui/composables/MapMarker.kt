package com.cdv.pokemongo.ui.composables

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import com.bumptech.glide.Glide
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


suspend fun loadBitmapDescriptorFromUrl(context: Context, imageUrl: String): BitmapDescriptor {
    return withContext(Dispatchers.IO) {
        Glide.with(context)
            .asBitmap()
            .load(imageUrl)
            .circleCrop()
            .submit()
            .get()
    }
        .let { bitmap ->
            val resizedBitmap = Bitmap.createScaledBitmap(bitmap, 500, 500, false)
            BitmapDescriptorFactory.fromBitmap(resizedBitmap)
        }
}

fun createBitmapFromResource(resourceId: Int?, context: Context): BitmapDescriptor? {
    if (resourceId == null) return null;
    val bitmap = BitmapFactory.decodeResource(context.resources, resourceId)
    val scaledBitmap = Bitmap.createScaledBitmap(bitmap, 200, 200, false);
    return BitmapDescriptorFactory.fromBitmap(scaledBitmap)
}

@Composable
fun MapMarker(
    latLng: LatLng,
    imageUrl: String? = null,
    onClick: (Marker) -> Unit = {},
    imageDrawableId: Int? = null,
    title: String? = null
) {

    val context = LocalContext.current
    val bitmapIcon = createBitmapFromResource(imageDrawableId, context)
    val iconState =
        remember { mutableStateOf(bitmapIcon) }
    LaunchedEffect(key1 = Unit, block = {
        if (imageUrl != null)
            iconState.value = loadBitmapDescriptorFromUrl(
                context,
                imageUrl
            )
    })



    iconState.value?.let {
        Marker(
            state = MarkerState(position = latLng),
            icon = it,
            title = title,
            onClick = { marker ->
                onClick(marker)
                false
            })
    }
}
