package design_patterns.factory_method.after_3

interface Serializer {
    fun serialize(book: Book): String
}