package solid_principles.dependency_inversion_principle.after

object Config {
    const val storageType = "sql"
}

interface Storage

class SQLStorage : Storage

class Service(private val storage: Storage) {
    fun doSomething() {
        // storage.
    }
}

fun createStorage(): Storage {
    if (Config.storageType == "sql") {
        return SQLStorage()
    } else {
        throw Exception("Only sql storage is supported")
    }
}

fun main() {
    val storage = createStorage()

    val service = Service(storage)

    service.doSomething()
}
