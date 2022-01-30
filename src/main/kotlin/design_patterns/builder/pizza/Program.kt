package design_patterns.builder.pizza

data class Pizza internal constructor(
    val dough: String,
    val cheese: String,
    val condiments: List<String>,
    val toppings: List<String>
) {
    val hasPineapple: Boolean = true
}

class PizzaBuilder(private val dough: String, private val cheese: String) {
    private val condiments: MutableList<String> = mutableListOf()
    private var toppings: List<String> = emptyList()

    fun withCondiment(condiment: String): PizzaBuilder {
        this.condiments.add(condiment)
        return this
    }

    fun withToppings(toppings: List<String>): PizzaBuilder {
        this.toppings = toppings
        return this
    }

    fun build(): Pizza = Pizza(this.dough, this.cheese, this.condiments, this.toppings)
}

fun main() {
    val pizza: Pizza = PizzaBuilder("New York", "Mozzarella")
        .withCondiment("Minced meat")
        .withCondiment("Ham")
        .withCondiment("Pepper")
        .withCondiment("Salt")
        .build()

    val toppings: MutableList<String> = mutableListOf()
    toppings.add("Pineapple")
    toppings.add("Ham")

    val pizza2: Pizza = PizzaBuilder("New York", "Mozzarella")
        .withToppings(toppings)
        .build()

    println(pizza2)

    toppings.add("Pepper")

    println(pizza2)
}
