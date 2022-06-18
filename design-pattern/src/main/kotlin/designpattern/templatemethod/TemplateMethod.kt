package designpattern.templatemethod

abstract class Teacher {

    fun startClass() {
        inside()
        attendance()
        teach()
        outside()
        println("----------------")
    }

    private fun inside() = println("선생님이 강의실로 들어옵니다.")
    private fun attendance() = println("선생님이 출석을 부릅니다.")
    private fun outside() = println("선생님이 강의실을 나갑니다.")

    protected abstract fun teach()
}

class KoreanTeacher : Teacher() {
    override fun teach() {
        println("선생님이 국어를 수업합니다.")
    }
}

class EnglishTeacher : Teacher() {
    override fun teach() {
        println("선생님이 영어를 수업합니다.")
    }
}

class MathTeacher : Teacher() {
    override fun teach() {
        println("선생님이 수학을 수업합니다.")
    }
}

fun main() {
    val koreanTeacher = KoreanTeacher()
    val englishTeacher = EnglishTeacher()
    val mathTeacher = MathTeacher()

    koreanTeacher.startClass()
    englishTeacher.startClass()
    mathTeacher.startClass()
}