package com.infy.location.test.app.models

// Model class is responsible for processed filtering algorithm or API result
data class CarAPIResultData(
    val latitude: Double?,
    val longitude: Double?,
    val shops: String?,
    val hisData: String?,
    val rest: String?,
    val places: String?
)
