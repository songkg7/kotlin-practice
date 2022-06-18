package designpattern.proxy

class ProxyRider(val name: String) : Rider {

    private var fullTimeRider: FullTimeRider? = null

    override fun delivery() = (fullTimeRider ?: FullTimeRider(name)).delivery()

    override fun getPersonal(level: Int) = name
}