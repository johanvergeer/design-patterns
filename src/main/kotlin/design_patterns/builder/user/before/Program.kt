package design_patterns.builder.user.before

class User(val firstName: String, val lastName: String, val age: Int?, val phone: String?, val address: String?) {
    constructor(firstName: String, lastName: String) :
        this(firstName, lastName, null, null, null)

    constructor(firstName: String, lastName: String, age: Int) :
        this(firstName, lastName, age, null, null)

    constructor(firstName: String, lastName: String, age: Int, phone: String) :
        this(firstName, lastName, age, phone, null)

    constructor(firstName: String, lastName: String, phone: String) :
        this(firstName, lastName, null, phone, null)
}

fun main() {
    val user = User("Johan", "Vergeer", null, null, null)
}
