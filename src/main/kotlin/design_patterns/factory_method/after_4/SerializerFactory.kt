package design_patterns.factory_method.after_4

class SerializerFactory {
    private val serializers = mutableMapOf<String, Serializer>()

    fun create(format: String): Serializer {
        return this.serializers.getOrElse(format) { throw Exception("format '$format' not recognised") }
    }

    fun register(format: String, serializer: Serializer) {
        this.serializers[format] = serializer
    }
}
