package solid_principles.dependency_inversion_principle.before

class Storage

fun createStorage(): Storage {
    return Storage()
}

class Service {
    val storage = createStorage()
}
