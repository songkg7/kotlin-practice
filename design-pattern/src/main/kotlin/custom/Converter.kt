package custom

interface Converter<I, O> {

    fun convert(s: I): O

}

class ListConverter : Converter<String, List<String>> {

    override fun convert(s: String) = s.toList().map { it.toString() }

    fun customConvert(): List<String> {
        return stringConverter("test")
    }

}

val stringConverter: (String) -> List<String> = { it.toList().map { c: Char -> c.toString() } }
