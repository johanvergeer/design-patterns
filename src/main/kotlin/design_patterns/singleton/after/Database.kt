package design_patterns.singleton.after

internal class Database private constructor() {
    val connection: Unit
        get() = println("You are now connected to the database.")

    companion object {
        private var dbObject: Database? = null
        // create object if it's not already created

        // returns the singleton object
        val instance: Database?
            get() {
                // create object if it's not already created
                if (this.dbObject == null) {
                    this.dbObject = Database()
                }

                // returns the singleton object
                return this.dbObject
            }
    }
}
