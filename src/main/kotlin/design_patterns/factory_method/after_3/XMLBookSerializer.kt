package design_patterns.factory_method.after_3

import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule
import com.fasterxml.jackson.dataformat.xml.XmlMapper

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
