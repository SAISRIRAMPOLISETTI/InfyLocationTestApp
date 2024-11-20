package com.infy.location.test.app

import android.content.Context
import android.content.pm.PackageManager
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.infy.location.test.app.models.CarLocationData
import com.infy.location.test.app.storage.DataStorage

class MainActivity : AppCompatActivity() {

    private var carManager: CARManager? = null
    private var carModel: String? = null
    private var dataStorage: DataStorage? = null

    private var locationManager: LocationManager? = null
    private val locationListener = LocationListener { location ->
        // Handle location updates
        // sending location data model[i.e latitude and longitude] to filtering algorithm or API.
        val locationResult = carManager?.sendRawLocationDataToFilteringAPI(
            CarLocationData(
                carModel,
                location.latitude,
                location.longitude,
                System.currentTimeMillis()
            )
        )
        // process filtering algorithm/API result
        val locationDetails = carManager?.processLocationResult(locationResult)
        // save location data
        dataStorage?.saveLocationData(carModel, locationDetails)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Application launched.
        carManager = CARManager()

        // Get current CAR model using car ID.
        carModel = carManager?.getCarID()?.let { carManager?.getCarModel(it) } ?: ""

        // User clicks button or some another way to start storing data based on location.
        // Below steps will execute after user interaction.
        dataStorage = DataStorage(this)
        // Initialize LocationManager
        locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        // Check for location permissions and request updates
        checkLocationPermissions()
    }

    // Method to Check location permissions.
    private fun checkLocationPermissions() {
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // Request location permissions if not granted
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                LOCATION_PERMISSION_REQUEST_CODE
            )
        } else {
            // Start location updates
            startLocationUpdates()
        }
    }

    // Method to set location updates.
    private fun startLocationUpdates() {
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            locationManager?.requestLocationUpdates(
                LocationManager.GPS_PROVIDER,
                1000L, // Minimum time interval between updates (in milliseconds)
                1f,    // Minimum distance between updates (in meters)
                locationListener
            )
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                startLocationUpdates()
            } else {
                Toast.makeText(this, "Location permission denied", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onStop() {
        super.onStop()
        // Stop location updates
        locationManager?.removeUpdates(locationListener)
    }

    companion object {
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1
    }
}