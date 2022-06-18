package proxy

interface Rider {
    fun delivery(): String
    fun getPersonal(level: Int): String?
}