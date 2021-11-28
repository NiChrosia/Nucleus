package nucleus.common.phase

/** A simple wrapper for dispatching phases. */
open class PhaseDispatcher<A, L : Phase.Listener<A>> {
    /** The phases contained within this dispatcher. Addition to this is intended to be done via [collected]. */
    val phases = mutableListOf<Phase<A, L>>()

    /** Add the given phase to [phases]. */
    open fun <P : Phase<A, L>> P.collected(): P {
        return also(phases::add)
    }

    /** Execute all phases & listeners dependent on priority. */
    open fun execute(arguments: A) {
        phases.sortedBy { it.priority }.forEach {
            it.listeners.forEach {
                it.execute(arguments)
            }
        }
    }
}