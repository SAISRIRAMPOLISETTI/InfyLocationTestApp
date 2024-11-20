package com.infy.location.test.app

import com.infy.location.test.app.api.CarLocationApiImporter
import com.infy.location.test.app.filters.LocationDataFilter
import com.infy.location.test.app.models.CarAPIResultData
import com.infy.location.test.app.models.CarLocationData

/*
*API class.
* */

class CARManager {

    private var locationDataFilter: LocationDataFilter? = null
    private var carLocationAPIImporter: CarLocationApiImporter? = null

    init {
        // Initializing Car location data processor API class
        carLocationAPIImporter = CarLocationApiImporter()
    }

    // Method to get car unique Id
    fun getCarID(): String {
        // call specific CAR API and return Car ID.
        return "car_unique_id"
    }

    // Method to get CAR model using carId.
    fun getCarModel(carId: String): String {
        // Call specific API to get CAR model.
        // Currently I am returning sedan car model.
        // we have different car models i.e sedan, suv.. etc
        return "Model_Sedan"
    }

    // Method to share car location details to filtering algorithm or API
    fun sendRawLocationDataToFilteringAPI(carLocationData: CarLocationData): String? {
        return carLocationAPIImporter?.processCarLocationData(carLocationData)
    }

    // Method to process filtering algorithm or API result
    fun processLocationResult(locationResult: String?): ArrayList<CarAPIResultData>? {
        if (locationDataFilter == null)
            locationDataFilter = LocationDataFilter()
        return locationDataFilter?.filterLocationData(locationResult)
    }
}
