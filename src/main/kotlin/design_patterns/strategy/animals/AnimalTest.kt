package design_patterns.strategy.animals

class AnimalTest {
    fun makeSomeAnimals() {
        val dog: Animal = Dog()
        val cat: Animal = Cat()

        // treat dogs and cats as their supertype, Animal
        val animals = ArrayList<Animal>()
        animals.add(dog)
        animals.add(cat)

        animals.forEach { it.makeSound() } // can call makeSound on any Animal
    }

    abstract inner class Animal {
        abstract fun makeSound()
    }

    inner class Dog : Animal() {
        override fun makeSound() = bark()
        fun bark() = println("Woof")
    }

    inner class Cat : Animal() {
        override fun makeSound() = this.meow()
        fun meow() = println("Meow")
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val at = AnimalTest()
            at.makeSomeAnimals()
        }
    }
}
