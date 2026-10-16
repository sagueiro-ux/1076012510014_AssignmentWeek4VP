package com.seanagueiro.a1076012510014_assignmentweek4vp.ui.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

fun getFuelBadgeColors(fuelType: String): Pair<Color, Color> {
    return when (fuelType.uppercase().trim()) {
        "PHEV" -> Pair(Color(0xFFE2D9F3), Color(0xFF5E3A8C))
        "ELECTRIC" -> Pair(Color(0xFFD8F3EC), Color(0xFF1B6B58))
        "PETROL" -> Pair(Color(0xFFFFF1C5), Color(0xFFC07000))
        "DIESEL" -> Pair(Color(0xFFEAD1D9), Color(0xFFE91E63))
        else -> Pair(Color(0xFFE5E7EB), Color(0xFF374151))
    }
}

@Composable
fun FuelBadge(
    fuelType: String,
    modifier: Modifier = Modifier
) {
    val (backgroundColor, textColor) = getFuelBadgeColors(fuelType)

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(6.dp))
            .background(backgroundColor)
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Text(
            text = fuelType,
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold,
            color = textColor
        )
    }
}