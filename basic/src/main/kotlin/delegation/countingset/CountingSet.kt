package delegation.countingset

class CountingSet(private val delegate: MutableSet<Long> = HashSet()) :
    MutableSet<Long> by delegate {

    private var addCount = 0L

    override fun add(element: Long): Boolean {
        addCount++
        return delegate.add(element)
    }

    override fun addAll(elements: Collection<Long>): Boolean {
        addCount += elements.size
        return delegate.addAll(elements)
    }
}
