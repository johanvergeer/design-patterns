package design_patterns.factory_method.after_4

import com.google.gson.GsonBuilder

class JSONBookSerializer: Serializer {
    override fun serialize(book: Book): String {
        return GsonBuilder().setPrettyPrinting().create().toJson(book)
    }
}