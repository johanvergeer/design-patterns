package solid_principles.dependency_inversion_principle.after

fun createStorage(): Storage {
    if (Config.storageType == "sql") {
        return SQLStorage()
    } else {
        throw Exception("Only sql storage is supported")
    }
}
