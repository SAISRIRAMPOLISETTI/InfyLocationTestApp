package com.infy.location.test.app.filters

import com.infy.location.test.app.models.CarAlgorithmData

// LocationDataFilter is responsible to process algorithm result.
class LocationDataFilter {

    // Method to filter location result.
    fun filterLocationData(locationResult: String?): ArrayList<CarAlgorithmData> {
        // Process the location result.
        // Here I assumed data received in string format i.e JSON or other format.
        // Process JSON data and map to our data model using iterator
        // Divide data according to our need i.e historical, hotels, places.. etc.
        // Add all location data models to one list.
        return ArrayList()
    }
}