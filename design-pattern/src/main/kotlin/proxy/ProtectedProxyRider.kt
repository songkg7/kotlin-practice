package proxy

class ProtectedProxyRider(var name: String) : Rider {

    private val fullTimeRider: FullTimeRider? = null

    private fun getRider(name: String) = fullTimeRider ?: FullTimeRider(name)

    override fun delivery() = getRider(name).delivery()

    override fun getPersonal(level: Int): String? {
        if (level > 3) {
            return getRider(name).getPersonal(level)
        }
        return "접근 불가"
    }
}