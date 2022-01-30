package design_patterns.factory_method.book_serializer.after_3

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
    fun create(format: String): Serializer {
        return when (format) {
            "JSON" -> JSONBookSerializer()
            "XML" -> XMLBookSerializer()
            else -> throw Exception("format should be 'JSON' or 'XML', not '$format'")
        }
    }
}

fun main() {
    val book = Book(1234, "The Hobbit", "JRR Tolkien")

    val serializer = SerializerFactory().create("JSON")

    println(serializer.serialize(book))
}
