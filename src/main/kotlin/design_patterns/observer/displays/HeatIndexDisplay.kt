package design_patterns.observer.displays

import design_patterns.observer.DisplayElement
import design_patterns.observer.Observer
import design_patterns.observer.WeatherData

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
