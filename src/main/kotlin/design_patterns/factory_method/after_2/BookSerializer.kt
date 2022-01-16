package design_patterns.factory_method.after_2

import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.google.gson.GsonBuilder

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
            JacksonXmlModule().apply { setDefaultUseWrapper(false) }
        ).apply {
            enable(SerializationFeature.INDENT_OUTPUT)
        }
        return xmlMapper.writeValueAsString(book)
    }
}