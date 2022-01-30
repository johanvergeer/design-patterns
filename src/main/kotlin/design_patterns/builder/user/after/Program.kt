package design_patterns.builder.user.after

data class User internal constructor(
    val firstName: String,
    val lastName: String,
    val age: Int?,
    val phone: String?,
    val address: String?,
    val employer: String?,
)

class UserBuilder(private val firstName: String, private val lastName: String) {
    private var age: Int? = null
    private var phone: String? = null
    private var address: String? = null
    private var employer: String? = null

    fun withAge(age: Int): UserBuilder {
        this.age = age
        return this
    }

    fun withPhone(phone: String): UserBuilder {
        this.phone = phone
        return this
    }

    fun withAddress(address: String): UserBuilder {
        this.address = address
        return this
    }

    fun withEmployer(employer: String): UserBuilder {
        this.employer = employer
        return this
    }

    fun build() = User(this.firstName, this.lastName, this.age, this.phone, this.address, this.employer)
}

fun main() {
    val user: User = UserBuilder("Johan", "Vergeer")
        .withAge(40)
        .withPhone("06-00000000")
        .withEmployer("Pythoneers")
        .build()

    print(user)
}
