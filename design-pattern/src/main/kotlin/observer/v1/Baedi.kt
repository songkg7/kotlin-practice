package observer.v1

class Baedi : Coach {

    private val crews = mutableListOf<Crew>()

    fun eatFood() {
        println("베디 코치가 밥을 먹는다.")
        notifyCrew("나 밥 먹었다.")
    }

    fun runaway() {
        println("베디 코치가 농땡이를 친다.")
        notifyCrew("나 농땡이 치러 간다.")
    }

    fun upgradeCutie() {
        println("베디 코치가 귀여움을 강화했다.")
        notifyCrew("나 더 귀여워졌다.")
    }

    override fun subscribe(crew: Crew) {
        crews.add(crew)
    }

    override fun unsubscribe(crew: Crew) {
        crews.remove(crew)
    }

    override fun notifyCrew(message: String) {
        crews.forEach { it.update(message) }
    }
}
