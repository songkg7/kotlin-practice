package proxy

class FullTimeRider(val name: String) : Rider {

    override fun delivery() = "음식배달"

    override fun getPersonal(level: Int) = name
}