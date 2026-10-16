
package com.seanagueiro.a1076012510014_assignmentweek4vp.ui.screen

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.seanagueiro.a1076012510014_assignmentweek4vp.ui.theme.CarBackground
import com.seanagueiro.a1076012510014_assignmentweek4vp.ui.theme.CarDark
import com.seanagueiro.a1076012510014_assignmentweek4vp.ui.theme.CarGray
import com.seanagueiro.a1076012510014_assignmentweek4vp.ui.theme.CarOrange
import com.seanagueiro.a1076012510014_assignmentweek4vp.ui.theme.CarSoftOrange
import com.seanagueiro.a1076012510014_assignmentweek4vp.ui.theme.Week4Theme
import com.seanagueiro.a1076012510014_assignmentweek4vp.ui.widgets.CarCard
import com.seanagueiro.a1076012510014_assignmentweek4vp.viewmodel.Soal1ViewModel

@Composable
fun Soal1(viewModel: Soal1ViewModel = viewModel()) {
    val selectedCar = viewModel.getSelectedCar()

    BackHandler(enabled = selectedCar != null) {
        viewModel.closeDetail()
    }
    if (selectedCar != null) {
        Soal1Detail(
            car = selectedCar,
            onBack = { viewModel.closeDetail() },
            onFavoriteClick = {
                viewModel.toggleFavorite(selectedCar.id)
            }
        )
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(CarBackground)
                .statusBarsPadding()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                Column {
                    Box(
                        modifier = Modifier
                            .width(36.dp)
                            .height(4.dp)
                            .clip(RoundedCornerShape(2.dp))
                            .background(CarOrange)
                    )

                    Spacer(Modifier.height(8.dp))

                    Text(
                        text = "On Sale",
                        fontSize = 34.sp,
                        fontWeight = FontWeight.Bold,
                        color = CarDark
                    )

                    Text(
                        text = "Find your perfect ride",
                        fontSize = 14.sp,
                        color = CarGray
                    )
                }

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(50))
                        .background(CarSoftOrange)
                        .border(
                            1.dp,
                            CarOrange.copy(alpha = 0.4f),
                            RoundedCornerShape(50)
                        )
                        .padding(
                            horizontal = 12.dp,
                            vertical = 6.dp
                        )
                ) {

                    Text(
                        text = "♥ ${viewModel.getSavedCount()} saved",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = CarOrange
                    )
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(Color(0xFFE5DED8))
            )

            LazyColumn(
                modifier = Modifier.weight(1f),
                contentPadding = PaddingValues(
                    start = 16.dp,
                    end = 16.dp,
                    top = 16.dp,
                    bottom = 32.dp
                ),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                items(viewModel.cars) { car ->
                    CarCard(
                        car = car,
                        onCarClick = {
                            viewModel.openDetail(carId = car.id)
                        },
                        onFavoriteClick = {
                            viewModel.toggleFavorite(carId = car.id)
                        }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Soal1Preview() {
    Week4Theme {
        Soal1()
    }
}
