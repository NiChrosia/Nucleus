package nucleus.common.division

import nucleus.common.member.Member
import nucleus.common.phase.Phase
import nucleus.common.phase.PhaseDispatcher

/** Phase dispatcher for registrar roots. */
open class RegistrarPhaseDispatcher<R : RegistrarRoot<R>> : PhaseDispatcher<R, Phase.Listener<R>>() {
    /** Registration of content, typically via [Member]s. */
    val register = Phase<R, Phase.Listener<R>>(100).collected()

    /** Publication of content, typically to vanilla registries. */
    val publish = Phase<R, Phase.Listener<R>>(200).collected()

    /** Datagen of various types, e.g. lang, models, loot tables, etc. */
    val datagen = Phase<R, Phase.Listener<R>>(300).collected()
}