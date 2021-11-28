package nucleus.common.phase

import nucleus.common.division.RegistrarPhaseDispatcher

/** An prioritized object containing listeners to be executed based on this phase's [priority]. A lower priority means
 * that this phase will execute earlier.
 *
 * Examples are listed in [RegistrarPhaseDispatcher]'s `register`, `publish`, and
 * `datagen`. */
open class Phase<A, L : Phase.Listener<A>>(val priority: Int) {
    val listeners = mutableListOf<L>()

    fun interface Listener<A> {
        fun execute(arguments: A)
    }
}