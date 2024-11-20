package com.infy.location.test.app.storage

import com.infy.location.test.app.models.CarAPIResultData

// Common interface to store location data
// This interface is useful if app have multiple storage preferences.
interface ILocationDataExporter {
    fun saveLocationData(carModel: String?, locationData: ArrayList<CarAPIResultData>?)
    fun loadLocationData(carModel: String)
}