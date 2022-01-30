package design_patterns.factory_method.book_serializer.after_2

import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.google.gson.GsonBuilder

data class Book(val bookId: Int, val title: String, val author: String)

class BookSerializer {
    fun serialize(book: Book, format: String): String {
        val serializer = this.getSerializer(format)
        return serializer(book)
    }

    private fun getSerializer(format: String): (book: Book) -> String {
        return when (format) {
            "JSON" -> this::serializeJson
            "XML" -> this::serializeXml
            else -> throw Exception("format should be 'JSON' or 'XML', not '$format'")
        }
    }

    private fun serializeJson(book: Book): String {
        return GsonBuilder().setPrettyPrinting().create().toJson(book)
    }

    private fun serializeXml(book: Book): String {
        val xmlMapper = XmlMapper(
            JacksonXmlModule().apply { this.setDefaultUseWrapper(false) }
        ).apply {
            this.enable(SerializationFeature.INDENT_OUTPUT)
        }
        return xmlMapper.writeValueAsString(book)
    }
}

fun main() {
    val book = Book(1234, "The Hobbit", "JRR Tolkien")

    val serializer = BookSerializer()

    println(serializer.serialize(book, "JSON"))
    println(serializer.serialize(book, "XML"))
}
