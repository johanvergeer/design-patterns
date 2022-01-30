package design_patterns.factory_method.book_serializer.before

import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.google.gson.GsonBuilder

data class Book(val bookId: Int, val title: String, val author: String)

class BookSerializer {
    fun serialize(book: Book, format: String): String {
        return when (format) {
            "JSON" -> {
                GsonBuilder().setPrettyPrinting().create().toJson(book)
            }
            "XML" -> {
                val xmlMapper = XmlMapper(
                    JacksonXmlModule().apply { this.setDefaultUseWrapper(false) }
                ).apply {
                    this.enable(SerializationFeature.INDENT_OUTPUT)
                }
                return xmlMapper.writeValueAsString(book)
            }
            else -> {
                throw Exception("format should be 'JSON' or 'XML', not '$format'")
            }
        }
    }
}

fun main() {
    val book = Book(1234, "The Hobbit", "JRR Tolkien")

    val serializer = BookSerializer()

    println(serializer.serialize(book, "XML"))
}
