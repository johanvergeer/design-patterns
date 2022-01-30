package design_patterns.strategy.animals

abstract class Animal {
    abstract fun makeSound()
}

class Dog : Animal() {
    override fun makeSound() = bark()
    fun bark() = println("Woof")
}

class Cat : Animal() {
    override fun makeSound() = this.meow()
    fun meow() = println("Meow")
}

fun makeSomeAnimals() {
    val dog: Animal = Dog()
    val cat: Animal = Cat()

    // treat dogs and cats as their supertype, Animal
    val animals = mutableListOf<Animal>()
    animals.add(dog)
    animals.add(cat)

    animals.forEach { it.makeSound() } // can call makeSound on any Animal
}

fun main() {
    makeSomeAnimals()
}
