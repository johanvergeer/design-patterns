package design_patterns.singleton.database.after_2

object Database {
    val pool = listOf("conn1", "conn2", "conn2")

    val connection: String
        get() {
            println("You are now connected to the database.")
            return pool.random()
        }
}

fun main() {
    val db = Database

    val conn = db.connection
}
