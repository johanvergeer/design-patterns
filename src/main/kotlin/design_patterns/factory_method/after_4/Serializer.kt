package design_patterns.factory_method.after_4

interface Serializer {
    fun serialize(book: Book): String
}