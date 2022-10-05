package custom

interface Converter<I, O> {

    fun convert(s: I): O

}

class ListConverter : Converter<String, List<String>> {

    override fun convert(s: String) = s.toList().map { it.toString() }

}
