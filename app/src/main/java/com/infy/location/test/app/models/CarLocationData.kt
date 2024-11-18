package com.infy.location.test.app.models

// Model class is responsible for location info i.e latitude and longitude
data class CarLocationData(
    val carModel: String?,
    val latitude: Double?,
    val longitude: Double?,
    val timeStamp: Long?
)
