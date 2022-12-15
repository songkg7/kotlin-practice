package observer.v1

interface Coach {

    fun subscribe(crew: Crew)

    fun unsubscribe(crew: Crew)

    // 코치가 크루들에게 메세지를 보낸다.
    fun notifyCrew(message: String)

}
