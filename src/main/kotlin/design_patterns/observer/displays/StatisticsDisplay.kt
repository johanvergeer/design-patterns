package design_patterns.observer.displays

import design_patterns.observer.DisplayElement
import design_patterns.observer.Observer
import design_patterns.observer.WeatherData
import java.math.MathContext

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
