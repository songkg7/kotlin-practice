package chainofresponsibility

interface DispenseChain {
    fun setNextChain(dispenseChain: DispenseChain)
    fun dispense(currency: Currency)
}

class Currency(val amount: Int)

class Won100Dispenser(private var dispenseChain: DispenseChain) : DispenseChain {

    override fun setNextChain(dispenseChain: DispenseChain) {
        this.dispenseChain = dispenseChain
    }

    override fun dispense(currency: Currency) {
        if (currency.amount >= 100) {
            val num = currency.amount / 100
            val remain = currency.amount % 100

            println("Dispensing $num * 100₩ note")
            if (remain != 0) {
                this.dispenseChain.dispense(Currency(remain))
            }
            return
        }
        this.dispenseChain.dispense(currency)
    }
}

class Won10Dispenser(private var dispenseChain: DispenseChain) : DispenseChain {

    override fun setNextChain(dispenseChain: DispenseChain) {
        this.dispenseChain = dispenseChain
    }

    override fun dispense(currency: Currency) {
        if (currency.amount >= 10) {
            val num = currency.amount / 10
            val remain = currency.amount % 10

            println("Dispensing $num * 10₩ note")
            if (remain != 0) {
                this.dispenseChain.dispense(Currency(remain))
            }
            return
        }
        this.dispenseChain.dispense(currency)
    }
}

class Won1Dispenser(private var dispenseChain: DispenseChain? = null) : DispenseChain {

    override fun setNextChain(dispenseChain: DispenseChain) {
        this.dispenseChain = dispenseChain
    }

    override fun dispense(currency: Currency) {
        val num = currency.amount

        println("Dispensing $num * 1₩ note")
    }
}

class ChainOfResponsibility(var dispenseChain: DispenseChain? = null) {
    init {
        dispenseChain = Won100Dispenser(Won10Dispenser(Won1Dispenser()))
    }
}

fun main() {
    val chainOfResponsibility = ChainOfResponsibility()
    chainOfResponsibility.dispenseChain?.dispense(Currency(378))
}