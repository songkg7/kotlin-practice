package designpattern.decorator

class Espresso : Coffee {

    override fun recipe(): String {
        return "에스프레소"
    }
}