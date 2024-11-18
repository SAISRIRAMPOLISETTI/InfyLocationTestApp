package com.infy.location.test.app.algorithms

import com.infy.location.test.app.models.CarLocationData

// CarAlgorithmImporter is responsible to load algorithm and process location data.
class CarAlgorithmImporter {

    fun load(algorithm: String) {
        // Load filtering algorithm based on CAR Model.
        when (algorithm) {
            "Algorithm_Sedan" -> "Initialize/Load Sedan Algorithm"
            "Algorithm_SUV" -> "Initialize/Load SUV Algorithm"
            else -> "Initialize/Load Default Algorithm"
        }
    }

    fun processCarLocationData(carLocationData: CarLocationData): String {
        // call specific algorithm API to get location result.
        return ""
    }
}
