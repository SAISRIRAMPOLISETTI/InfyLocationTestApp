package com.infy.location.test.app.storage

import com.infy.location.test.app.models.CarAlgorithmData

// Common interface to store location data
interface ILocationDataExporter {
    fun saveLocationData(carModel: String?, locationData: ArrayList<CarAlgorithmData>?)
    fun loadLocationData(carModel: String)
}