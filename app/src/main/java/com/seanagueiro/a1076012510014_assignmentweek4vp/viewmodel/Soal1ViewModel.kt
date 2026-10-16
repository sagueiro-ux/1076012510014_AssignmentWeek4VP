
package com.seanagueiro.a1076012510014_assignmentweek4vp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.seanagueiro.a1076012510014_assignmentweek4vp.model.Car

class Soal1ViewModel : ViewModel() {

    val cars = mutableStateListOf<Car>()

    var selectedCarId by mutableStateOf<Int?>(null)

    init {
        cars.add(
            Car(
                id = 1,
                name = "Tiggo 9 CSH",
                transmission = "Auto",
                year = "2024",
                mileage = "5,000 km",
                fuelType = "PHEV",
                location = "Jakarta",
                price = "Rp 780.000.000",
                description = "The Tiggo 9 CSH is a spacious plug-in hybrid SUV. It can drive on electric power for daily trips and switch to petrol for long journeys, with a premium interior and many safety features.",
                imageName = "car_tiggo",
                isFavorite = true
            )
        )

        cars.add(
            Car(
                id = 2,
                name = "Honda CRV",
                transmission = "Auto",
                year = "2013",
                mileage = "15,200 km",
                fuelType = "Petrol",
                location = "Bandung",
                price = "Rp 165.000.000",
                description = "A comfortable and reliable family SUV with low mileage. Well maintained, spacious cabin, and a smooth 2.0L engine that is great for the city and the highway.",
                imageName = "car_crv",
                isFavorite = false
            )
        )

        cars.add(
            Car(
                id = 3,
                name = "Toyota Yaris Cross",
                transmission = "Auto",
                year = "2024",
                mileage = "30,500 km",
                fuelType = "Hybrid",
                location = "Surabaya",
                price = "Rp 395.000.000",
                description = "A compact crossover with a fuel-saving hybrid system. High ground clearance, modern look, and a quiet cabin make it perfect for everyday driving.",
                imageName = "car_yariscross",
                isFavorite = true
            )
        )

        cars.add(
            Car(
                id = 4,
                name = "Daihatsu Xenia",
                transmission = "Manual",
                year = "2022",
                mileage = "28,000 km",
                fuelType = "Petrol",
                location = "Yogyakarta",
                price = "Rp 185.000.000",
                description = "An affordable 7-seater MPV that is easy to maintain. Great for big families and small businesses, with a wide cabin and a fuel efficient engine.",
                imageName = "car_xenia",
                isFavorite = false
            )
        )

        cars.add(
            Car(
                id = 5,
                name = "Toyota Yaris",
                transmission = "Auto",
                year = "2021",
                mileage = "52,400 km",
                fuelType = "Petrol",
                location = "Semarang",
                price = "Rp 245.000.000",
                description = "The Toyota Yaris G GAT is a sporty compact hatchback that punches above its weight class. Equipped with a 1.5L dual VVT-i engine, 7 airbags, pre-collision system, and a floating head unit, it offers premium features at a very accessible price point.",
                imageName = "car_yaris",
                isFavorite = true
            )
        )

        cars.add(
            Car(
                id = 6,
                name = "Honda HRV",
                transmission = "Auto",
                year = "2022",
                mileage = "18,900 km",
                fuelType = "Petrol",
                location = "Jakarta",
                price = "Rp 270.000.000",
                description = "The Honda HR-V is a popular subcompact crossover SUV manufactured by the Japanese automaker Honda. The acronym HR-V officially stands for \"Hi-rider Revolutionary Vehicle\" (or High Rider Vehicle in some regions).",
                imageName = "car_hrv",
                isFavorite = true
            )
        )

        cars.add(
            Car(
                id = 7,
                name = "Toyota Ayla",
                transmission = "Manual",
                year = "2020",
                mileage = "45,000 km",
                fuelType = "Petrol",
                location = "Malang",
                price = "Rp 160.000.000",
                description = "The Toyota Agya (known as the Daihatsu Ayla under their manufacturing partnership) is a highly popular, entry-level five-seater city hatchback.",
                imageName = "car_ayla",
                isFavorite = false
            )
        )

        cars.add(
            Car(
                id = 8,
                name = "Jaecoo J5",
                transmission = "Auto",
                year = "2025",
                mileage = "1,200 km",
                fuelType = "Electric",
                location = "Denpasar",
                price = "Rp 250.000.000",
                description = "The Jaecoo J5 (also known as the Jaecoo 5) is a premium B-segment subcompact crossover SUV produced by Chery under the adventure-oriented Jaecoo brand.",
                imageName = "car_j5",
                isFavorite = true
            )
        )

        cars.add(
            Car(
                id = 9,
                name = "MG 4 EV",
                transmission = "Auto",
                year = "2023",
                mileage = "9,800 km",
                fuelType = "Electric",
                location = "Denpasar",
                price = "Rp 185.000.000",
                description = "MG4 EV is a fully electric compact hatchback developed by MG Motor. Built on the dedicated Nebula Pure Electric Platform (Modular Scalable Platform), it is highly acclaimed for offering excellent driving dynamics, futuristic design, and exceptional value for money.",
                imageName = "car_mg4",
                isFavorite = true
            )
        )

        cars.add(
            Car(
                id = 10,
                name = "Toyota Innova Reborn",
                transmission = "Auto",
                year = "2021",
                mileage = "68,000 km",
                fuelType = "Diesel",
                location = "Denpasar",
                price = "Rp 150.000.000",
                description = "The Toyota Innova Reborn is the highly popular second generation of Toyota's iconic Multi-Purpose Vehicle (MPV), produced between 2015 and 2022.",
                imageName = "car_reborn",
                isFavorite = true
            )
        )
    }

    fun getSavedCount(): Int {
        var total = 0

        for (car in cars) {
            if (car.isFavorite) {
                total = total + 1
            }
        }

        return total
    }

    fun toggleFavorite(carId: Int) {
        for (i in cars.indices) {
            if (cars[i].id == carId) {
                cars[i] = cars[i].copy(
                    isFavorite = !cars[i].isFavorite
                )
            }
        }
    }

    fun openDetail(carId: Int) {
        selectedCarId = carId
    }

    fun closeDetail() {
        selectedCarId = null
    }

    fun getSelectedCar(): Car? {
        for (car in cars) {
            if (car.id == selectedCarId) {
                return car
            }
        }

        return null
    }
}
