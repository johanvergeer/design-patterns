package design_patterns.factory_method.before

import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.google.gson.GsonBuilder

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
