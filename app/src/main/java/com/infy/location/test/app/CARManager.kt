package com.infy.location.test.app

import com.infy.location.test.app.algorithms.CarAlgorithmImporter
import com.infy.location.test.app.filters.LocationDataFilter
import com.infy.location.test.app.models.CarAlgorithmData
import com.infy.location.test.app.models.CarLocationData

/*
*API class.
* */

class CARManager {

    private var locationDataFilter: LocationDataFilter? = null
    private var carAlgorithmImporter: CarAlgorithmImporter? = null

    // Method to get car unique Id
    fun getCarID(): String {
        // call specific CAR API and return Car ID.
        return "car_unique_id"
    }

    // Method to get CAR model using carId.
    fun getCarModel(carId: String): String {
        // Call specific API to get CAR model.
        return "Model_Sedan"
    }

    // Method to select filtering algorithm for CAR model
    fun fetchAlgorithmForCarModel(carModel: String?): String {
        return when (carModel) {
            "Model_Sedan" -> "Algorithm_Sedan"
            "Model_SUV" -> "Algorithm_SUV"
            else -> "DefaultAlgorithm"
        }
    }

    // Method to load filtering algorithm
    fun loadLocationDataAlgorithm(algorithm: String?) {
        if (carAlgorithmImporter == null)
            carAlgorithmImporter = CarAlgorithmImporter()
        carAlgorithmImporter?.load(algorithm ?: "")
    }

    // Method to share car location details to filtering algorithm
    fun sendRawLocationDataToFilteringAlgorithm(carLocationData: CarLocationData): String? {
        return carAlgorithmImporter?.processCarLocationData(carLocationData)
    }

    // Method to process filtering algorithm result
    fun processLocationResult(locationResult: String?): ArrayList<CarAlgorithmData>? {
        if (locationDataFilter == null)
            locationDataFilter = LocationDataFilter()
        return locationDataFilter?.filterLocationData(locationResult)
    }
}
