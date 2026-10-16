package com.seanagueiro.a1076012510014_assignmentweek4vp.ui.widgets

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource

@Composable
fun CarImage(
    imageName: String,
    modifier: Modifier = Modifier,
    reqWidth: Int = 1080,
    reqHeight: Int = 900
) {
    val context = LocalContext.current
    val resourceId = context.resources.getIdentifier(
        imageName, "drawable", context.packageName
    )
    if (resourceId != 0) {
        Image(
            painter = painterResource(id = resourceId),
            contentDescription = null,
            modifier = modifier,
            contentScale = ContentScale.Crop
        )
    }
}