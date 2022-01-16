package design_patterns.observer.displays

import design_patterns.observer.DisplayElement
import design_patterns.observer.Observer
import design_patterns.observer.Subject

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
