package delegation.pattern

class ScreamBehavior(val n: String) : SoundBehavior {

    override fun makeSound() = println(n.uppercase())

}