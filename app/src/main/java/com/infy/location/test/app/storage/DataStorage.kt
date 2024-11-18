package com.infy.location.test.app.storage

import android.content.Context
import com.infy.location.test.app.models.CarAlgorithmData

// DataStorage is responsible to save and load location data.
class DataStorage(context: Context) {

    // Used Shared Preference for storing and retrieving location data.
    // We can use Data Store or Room Data base or others to store and retrieve location data.

    private val sharedPreferences =
        context.getSharedPreferences("CarLocationDataStorage", Context.MODE_PRIVATE)

    // Method to save location data
    fun saveLocationData(carModel: String?, locationData: ArrayList<CarAlgorithmData>?) {
        val editor = sharedPreferences.edit()
        // Save processed location list data.
        // or can save entire raw algorithm data.
        // Convert list data i.e locationData to string format using GSON.
        editor.putString(carModel, "GSON data")
        editor.apply()
    }

    // Method to load location data.
    fun loadLocationData(carModel: String): List<CarAlgorithmData> {
        // Get saved location data using car model
        // convert string format data to List using GSON
        val data = sharedPreferences.getString(carModel, null) ?: return emptyList()
        return ArrayList()
    }
}