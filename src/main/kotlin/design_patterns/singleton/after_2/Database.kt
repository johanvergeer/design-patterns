package design_patterns.singleton.after_2

object Database {
    val connection: Unit
        get() {
            println("You are now connected to the database.")
        }
}
