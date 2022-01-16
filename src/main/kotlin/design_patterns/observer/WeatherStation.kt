package design_patterns.observer

import design_patterns.observer.displays.CurrentConditionsDisplay
import design_patterns.observer.displays.ForecastDisplay
import design_patterns.observer.displays.StatisticsDisplay

fun main() {
    val weatherData = WeatherData()

    val currentConditionsDisplay = CurrentConditionsDisplay(weatherData)
    val statisticsDisplay = StatisticsDisplay(weatherData)
    val forecastDisplay = ForecastDisplay(weatherData)

    weatherData.setMeasurements(80f, 65f, 30.4f)
    weatherData.setMeasurements(82f, 70f, 29.2f)
    weatherData.setMeasurements(78f, 90f, 29.9f)
}
