package design_patterns.factory_method.after_4

fun main() {
    val book = Book(1234, "The Hobbit", "JRR Tolkien")

    val factory = SerializerFactory()
    factory.register("JSON", JSONBookSerializer())
    factory.register("XML", XMLBookSerializer())

    val serializer = factory.create("XML")

    println(serializer.serialize(book))
}
