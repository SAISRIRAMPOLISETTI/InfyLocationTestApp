# InfyLocationTestApp

The customer wants an application to present some data based on the location of the car. In order to
increase the quality of the data presented to the user, some filtering algorithm is needed in order
to process the raw location data. The algorithms will be developed by a neighbouring team.
Unfortunately, different car models will require different algorithms. The data shall also be stored
so that the user can look at historical data, using the application. The application do only need to
store this data when it is running though. The application will be started by explicitly by the
user.

#CARManager.kt
The CARManager class handles car-related location data processing. It retrieves car details, selects
and loads appropriate filtering algorithms based on the car model, and sends raw location data for
processing. The class also processes the algorithm's results into usable location data. It serves as
a central manager for integrating car data with location-based algorithms.

#DataStorage.kt
The DataStorage class handles storing and retrieving car location data using SharedPreferences. It
saves location data as a JSON string, enabling efficient storage and retrieval. The class utilizes
GSON to serialize and deserialize the location data to and from string format. It supports saving
and loading data for specific car models.

#CarAlgorithmImporter.kt
The CarAlgorithmImporter class manages the loading and execution of filtering algorithms for car
location data. It selects the appropriate algorithm based on the car model (e.g., Sedan, SUV, or
Default). The class provides functionality to process car location data using the loaded algorithm.
It ensures flexible and model-specific location processing.

#LocationDataFilter.kt
The LocationDataFilter class processes and filters location data received in string format, such as
JSON. It parses the data and maps it to the CarAlgorithmData model. The class organizes the data
into categories like historical sites, hotels, and places of interest. All processed data is
returned as a unified list.

#Assumption
The process involves analyzing car location changes by using latitude and longitude values to
evaluate raw location data based on time intervals and distances. The results will be processed and
stored, and when requested by the user, the data will be displayed.