package design_patterns.observer.weather_station

import java.math.MathContext

interface Observer {
    fun update(temp: Float, humidity: Float, pressure: Float)
}

interface Subject {
    fun registerObserver(observer: Observer)
    fun removeObserver(observer: Observer)
    fun notifyObservers()
}

interface DisplayElement {
    fun display()
}

//region DisplayElement implementations
class CurrentConditionsDisplay(private val weatherData: Subject) : Observer, DisplayElement {
    private var temperature = 0.0f
    private var humidity = 0.0f

    init {
        this.weatherData.registerObserver(this)
    }

    override fun display() {
        println("Current conditions: ${this.temperature} F degrees and ${this.humidity} % humidity")
        println()
    }

    override fun update(temp: Float, humidity: Float, pressure: Float) {
        this.temperature = temp
        this.humidity = humidity
        display()
    }
}

class ForecastDisplay(private val weatherData: WeatherData) : Observer, DisplayElement {
    private var currentPressure = 29.92f
    private var lastPressure = 0f

    init {
        this.weatherData.registerObserver(this)
    }

    override fun update(temp: Float, humidity: Float, pressure: Float) {
        this.lastPressure = this.currentPressure
        this.currentPressure = pressure
        display()
    }

    override fun display() {
        print("Forecast: ")
        if (currentPressure > lastPressure) println("Improving weather on the way!")
        else if (currentPressure == lastPressure) println("More of the same")
        else if (currentPressure < lastPressure) println("Watch out for cooler, rainy weather")
        println()
    }
}

class HeatIndexDisplay(weatherData: WeatherData) : Observer, DisplayElement {
    private var heatIndex = 0.0f

    init {
        weatherData.registerObserver(this)
    }

    override fun update(temp: Float, humidity: Float, pressure: Float) {
        this.heatIndex = computeHeatIndex(temp, humidity)
        display()
    }

    private fun computeHeatIndex(t: Float, rh: Float): Float =
        (
            (
                16.923 + 0.185212 * t + 5.37941 * rh - 0.100254 * t * rh + 0.00941695 * (t * t) +
                    0.00728898 * (rh * rh) + 0.000345372 * (t * t * rh)
                ) - 0.000814971 * (t * rh * rh) +
                0.0000102102 * (t * t * rh * rh) - 0.000038646 * (t * t * t) + 0.0000291583 *
                (rh * rh * rh) + 0.00000142721 * (t * t * t * rh) +
                0.000000197483 * (t * rh * rh * rh) - 0.0000000218429 * (t * t * t * rh * rh) +
                0.000000000843296 * (t * t * rh * rh * rh) -
                0.0000000000481975 * (t * t * t * rh * rh * rh)
            ).toFloat()

    override fun display() {
        println("Heat index is $heatIndex")
        println()
    }
}

class StatisticsDisplay(private val weatherData: WeatherData) : Observer, DisplayElement {
    private val temperatures = mutableListOf<Float>()
    private val humidities = mutableListOf<Float>()
    private val pressures = mutableListOf<Float>()

    init {
        this.weatherData.registerObserver(this)
    }

    override fun display() {
        println(
            """
            CURRENT WEATHER STATISTICS
            ==========================
            |             | Average |     Min |     Max |
            ${formatLine(this.temperatures, "Temperature")}
            ${formatLine(this.humidities, "Humidity")}
            ${formatLine(this.pressures, "Pressure")}
            
            """.trimIndent()
        )
    }

    private fun formatLine(values: List<Float>, name: String): String {
        return "| ${name.padEnd(11)} | ${values.average().formatValue()} | ${
        values.minOf { it }.formatValue()
        } | ${values.maxOf { it }.formatValue()} |"
    }

    private fun Double.formatValue(): String = this.toFloat().formatValue()
    private fun Float.formatValue(): String =
        toBigDecimal()
            .round(MathContext(6))
            .toString()
            .padStart(7)

    override fun update(temp: Float, humidity: Float, pressure: Float) {
        this.temperatures.add(temp)
        this.humidities.add(temp)
        this.pressures.add(pressure)

        display()
    }
}
//endregion

class WeatherData : Subject {
    private val observers: MutableList<Observer> = mutableListOf()

    private var temperature: Float = 0.0f
    private var humidity: Float = 0.0f
    private var pressure: Float = 0.0f

    override fun registerObserver(observer: Observer) {
        this.observers.add(observer)
    }

    override fun removeObserver(observer: Observer) {
        this.observers.remove(observer)
    }

    override fun notifyObservers() {
        this.observers.forEach { it.update(this.temperature, this.humidity, this.pressure) }
    }

    fun setMeasurements(temperature: Float, humidity: Float, pressure: Float) {
        this.temperature = temperature
        this.humidity = humidity
        this.pressure = pressure

        this.measurementsChanged()
    }

    /**
     * This method gets called whenever the whether measurements have been updated
     */
    private fun measurementsChanged() {
        this.notifyObservers()
    }
}

fun main() {
    val weatherData = WeatherData()

    val currentConditionsDisplay = CurrentConditionsDisplay(weatherData)
    val statisticsDisplay = StatisticsDisplay(weatherData)
    val forecastDisplay = ForecastDisplay(weatherData)

    weatherData.setMeasurements(80f, 65f, 30.4f)
    weatherData.setMeasurements(82f, 70f, 29.2f)
    weatherData.setMeasurements(78f, 90f, 29.9f)
}
