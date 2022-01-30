package design_patterns.factory_method.book_serializer.after_4

import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.google.gson.GsonBuilder

data class Book(val bookId: Int, val title: String, val author: String)

interface Serializer {
    fun serialize(book: Book): String
}

//region serializer implementations
class JSONBookSerializer : Serializer {
    override fun serialize(book: Book): String {
        return GsonBuilder().setPrettyPrinting().create().toJson(book)
    }
}

class XMLBookSerializer : Serializer {
    override fun serialize(book: Book): String {
        val xmlMapper = XmlMapper(
            JacksonXmlModule().apply { this.setDefaultUseWrapper(false) }
        ).apply {
            this.enable(SerializationFeature.INDENT_OUTPUT)
        }
        return xmlMapper.writeValueAsString(book)
    }
}
//endregion

class SerializerFactory {
    private val serializers = mutableMapOf<String, Serializer>()

    fun create(format: String): Serializer {
        return this.serializers.getOrElse(format) { throw Exception("format '$format' not recognised") }
    }

    fun register(format: String, serializer: Serializer) {
        this.serializers[format] = serializer
    }
}

fun main() {
    val book = Book(1234, "The Hobbit", "JRR Tolkien")

    val factory = SerializerFactory()
    factory.register("JSON", JSONBookSerializer())
    factory.register("XML", XMLBookSerializer())

    val serializer = factory.create("XML")

    println(serializer.serialize(book))
}
