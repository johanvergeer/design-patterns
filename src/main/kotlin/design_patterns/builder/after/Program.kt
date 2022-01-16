package design_patterns.builder.after

fun main() {
    val user = User.Builder("Johan", "Vergeer").withAge(40).withPhone("06-00000000").build()

    print(user)
}
