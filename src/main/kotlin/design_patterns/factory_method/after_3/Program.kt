package design_patterns.factory_method.after_3

fun main() {
    val book = Book(1234, "The Hobbit", "JRR Tolkien")

    val serializer = SerializerFactory().create("JSON")

    println(serializer.serialize(book))
}
