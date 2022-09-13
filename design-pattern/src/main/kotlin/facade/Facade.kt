package facade

class LocalDataSource() {
    private val data = mutableListOf<String>()

    fun save(data: List<String>) {
        this.data.addAll(data)
    }

    fun read() = data.toList()

    fun isEmpty() = data.isEmpty()
}

class NetworkDataSource() {

    fun get() = listOf("Harry Potter", "Ronald Weasley", "Hermione Granger")

}

class Repository(private val localDataSource: LocalDataSource, private val networkDataSource: NetworkDataSource) {
    fun fetch(): List<String> {
        if (localDataSource.isEmpty()) {
            localDataSource.save(networkDataSource.get())
        }
        return localDataSource.read()
    }
}
