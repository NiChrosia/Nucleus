package nucleus.common.builtin.division

import nucleus.common.division.RegistrarPhaseDispatcher
import nucleus.common.phase.Phase

/** Extension of [RegistrarPhaseDispatcher] to add a pack addition phase, called last. */
open class ModPhaseDispatcher<R : ModRoot<R>> : RegistrarPhaseDispatcher<R>() {
    /** Addition of the [RegistrarPack]. Separated into a different phase to avoid adding the pack before all data is
     * added. */
    val packAddition = Phase<R, Phase.Listener<R>>(400).collected()
}