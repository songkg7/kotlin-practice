package composite

interface Part

object Head : Part

object RightArm : Part

object LeftArm : Part

object RightLeg : Part

object LeftLeg : Part

class Exodia(
    private val parts: MutableList<Part> = mutableListOf(),
) : Part {
    fun add(part: Part) {
        parts.add(part)
        checkAllParts()
    }

    private fun checkAllParts() {
        if (parts.containsAll(listOf(Head, RightArm, LeftArm, RightLeg, LeftLeg))) {
            println("Exodia the Forbidden One has been summoned!")
        }
    }

}



