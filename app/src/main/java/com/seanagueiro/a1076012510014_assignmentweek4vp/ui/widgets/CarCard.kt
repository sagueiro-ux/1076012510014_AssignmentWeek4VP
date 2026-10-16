package com.seanagueiro.a1076012510014_assignmentweek4vp.ui.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.seanagueiro.a1076012510014_assignmentweek4vp.model.Car
import com.seanagueiro.a1076012510014_assignmentweek4vp.ui.theme.CarGray
import com.seanagueiro.a1076012510014_assignmentweek4vp.ui.theme.CarOrange

@Composable
fun CarCard(
    car: Car,
    onCarClick: () -> Unit,
    onFavoriteClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onCarClick() },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Gambar + Badge Bahan Bakar
            Box(
                modifier = Modifier
                    .size(width = 110.dp, height = 90.dp)
                    .clip(RoundedCornerShape(12.dp))
            ) {
                CarImage(
                    imageName = car.imageName,
                    modifier = Modifier.fillMaxSize()
                )

                FuelBadge(
                    fuelType = car.fuelType,
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(6.dp)
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            // Car Information
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = car.name,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF1F2937)
                    )
                    Text(
                        text = if (car.isFavorite) "♥" else "♡",
                        fontSize = 18.sp,
                        color = if (car.isFavorite) CarOrange else CarGray,
                        modifier = Modifier.clickable { onFavoriteClick() }
                    )
                }

                Spacer(modifier = Modifier.height(4.dp))

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(6.dp))
                        .background(Color(0xFFF3F4F6))
                        .padding(horizontal = 8.dp, vertical = 2.dp)
                ) {
                    Text(
                        text = car.transmission,
                        fontSize = 11.sp,
                        color = CarGray,
                        fontWeight = FontWeight.Medium
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .size(6.dp)
                                .clip(CircleShape)
                                .background(CarOrange)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = car.year,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF1F2937)
                        )
                    }

                    Text(
                        text = car.mileage,
                        fontSize = 12.sp,
                        color = CarGray
                    )
                }
            }
        }
    }
}