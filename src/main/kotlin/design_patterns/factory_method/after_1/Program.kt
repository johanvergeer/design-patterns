package design_patterns.factory_method.after_1

fun main() {
    val book = Book(1234, "The Hobbit", "JRR Tolkien")

    val serializer = BookSerializer()

    println(serializer.serialize(book, "JSON"))
    println(serializer.serialize(book, "XML"))
}
