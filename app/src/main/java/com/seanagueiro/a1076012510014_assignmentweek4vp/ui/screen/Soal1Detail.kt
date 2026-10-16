package com.seanagueiro.a1076012510014_assignmentweek4vp.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.seanagueiro.a1076012510014_assignmentweek4vp.model.Car
import com.seanagueiro.a1076012510014_assignmentweek4vp.ui.theme.CarBackground
import com.seanagueiro.a1076012510014_assignmentweek4vp.ui.theme.CarDark
import com.seanagueiro.a1076012510014_assignmentweek4vp.ui.theme.CarGray
import com.seanagueiro.a1076012510014_assignmentweek4vp.ui.theme.CarOrange
import com.seanagueiro.a1076012510014_assignmentweek4vp.ui.theme.CarSoftOrange
import com.seanagueiro.a1076012510014_assignmentweek4vp.ui.widgets.CarImage
import com.seanagueiro.a1076012510014_assignmentweek4vp.ui.widgets.FuelBadge

@Composable
fun Soal1Detail(
    car: Car,
    onBack: () -> Unit,
    onFavoriteClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(CarBackground)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        ) {
            CarImage(car.imageName, Modifier.fillMaxSize(), reqWidth = 1080, reqHeight = 900)

            Box(
                modifier = Modifier
                    .statusBarsPadding()
                    .padding(16.dp)
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(Color.White)
                    .clickable { onBack() },
                contentAlignment = Alignment.Center
            ) {
                Text("←", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = CarDark)
            }

            FuelBadge(
                fuelType = car.fuelType,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(start = 16.dp, bottom = 36.dp)
            )
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .offset(y = (-24).dp)
                .clip(RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp))
                .background(CarBackground)
                .verticalScroll(rememberScrollState())
                .padding(20.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    car.name,
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                    color = CarDark,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    if (car.isFavorite) "♥" else "♡",
                    fontSize = 30.sp,
                    color = if (car.isFavorite) CarOrange else CarGray,
                    modifier = Modifier.clickable { onFavoriteClick() }
                )
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(6.dp)
                        .clip(CircleShape)
                        .background(CarOrange)
                )
                Spacer(Modifier.width(6.dp))
                Text(car.location, fontSize = 14.sp, color = CarGray)
            }

            Spacer(Modifier.height(14.dp))

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .background(CarSoftOrange)
                    .border(1.dp, CarOrange.copy(alpha = 0.4f), RoundedCornerShape(10.dp))
                    .padding(horizontal = 14.dp, vertical = 8.dp)
            ) {
                Text(car.price, fontSize = 16.sp, fontWeight = FontWeight.Bold, color = CarOrange)
            }

            Spacer(Modifier.height(24.dp))

            Text("SPECIFICATIONS", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = CarGray)
            Spacer(Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                SpecBox("YEAR", car.year, Modifier.weight(1f))
                SpecBox("MILEAGE", car.mileage, Modifier.weight(1f))
            }
            Spacer(Modifier.height(12.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                SpecBox("TRANSMISSION", car.transmission, Modifier.weight(1f))
                SpecBox("FUEL TYPE", car.fuelType, Modifier.weight(1f))
            }

            Spacer(Modifier.height(24.dp))

            Text("ABOUT THIS CAR", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = CarGray)
            Spacer(Modifier.height(8.dp))
            Text(car.description, fontSize = 14.sp, lineHeight = 21.sp, color = Color(0xFF6B7280))
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .navigationBarsPadding()
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(52.dp)
                    .clip(RoundedCornerShape(14.dp))
                    .background(CarSoftOrange)
                    .border(1.dp, CarOrange.copy(alpha = 0.5f), RoundedCornerShape(14.dp))
                    .clickable { onFavoriteClick() },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    if (car.isFavorite) "♥" else "♡",
                    fontSize = 24.sp,
                    color = CarOrange
                )
            }

            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(52.dp)
                    .clip(RoundedCornerShape(14.dp))
                    .background(
                        Brush.horizontalGradient(
                            colors = listOf(Color(0xFFFF5A2E), Color(0xFFFF7A45))
                        )
                    )
                    .clickable { },
                contentAlignment = Alignment.Center
            ) {
                Text("Contact Seller", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.White)
            }
        }
    }
}

@Composable
private fun SpecBox(label: String, value: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .background(Color.White)
            .border(1.dp, Color(0xFFF1E3DC), RoundedCornerShape(12.dp))
            .padding(14.dp)
    ) {
        Text(label, fontSize = 10.sp, fontWeight = FontWeight.Bold, color = CarGray)
        Spacer(Modifier.height(4.dp))
        Text(value, fontSize = 15.sp, fontWeight = FontWeight.Bold, color = CarDark)
    }
}