package design_patterns.builder.after

class User internal constructor(builder: Builder) {
    val firstName: String = builder.firstName
    val lastName = builder.lastName
    val age = builder.age
    val phone = builder.phone
    val address = builder.address

    override fun toString(): String {
        return "User: ${this.firstName} ${this.lastName}, ${this.age} years old, ${this.phone}, ${this.address}"
    }

    class Builder(internal val firstName: String, internal val lastName: String) {
        internal var age: Int? = null
            private set
        internal var phone: String? = null
            private set
        internal var address: String? = null
            private set

        fun withAge(age: Int): Builder {
            this.age = age
            return this
        }

        fun withPhone(phone: String): Builder {
            this.phone = phone
            return this
        }

        fun withAddress(address: String): Builder {
            this.address = address
            return this
        }

        fun build() = User(this)
    }
}
