package design_patterns.observer

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
