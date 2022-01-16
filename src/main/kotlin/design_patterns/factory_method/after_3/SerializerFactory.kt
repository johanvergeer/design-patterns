package design_patterns.factory_method.after_3

class SerializerFactory {
    fun create(format: String): Serializer {
        return when (format) {
            "JSON" -> JSONBookSerializer()
            "XML" -> XMLBookSerializer()
            else -> throw Exception("format should be 'JSON' or 'XML', not '$format'")
        }
    }
}
