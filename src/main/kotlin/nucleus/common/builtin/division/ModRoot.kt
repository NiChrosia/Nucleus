package nucleus.common.builtin.division

import net.devtech.arrp.api.RuntimeResourcePack
import nucleus.common.builtin.division.content.ContentCategory
import nucleus.common.division.RegistrarRoot

/** An extension of [RegistrarRoot] to provide base objects for registration, e.g. items, blocks, block entities,
 * etc. It also contains an extension of [RuntimeResourcePack] to allow datagen at runtime. */
abstract class ModRoot<R : ModRoot<R>>(id: String) : RegistrarRoot<R>(id) {
    /** Dispatcher object for mod content. Contains an extra phase, `packAddition`, that adds the pack to the RRP
     * callback, and adds the English lang entries. */
    override val dispatcher = ModPhaseDispatcher<R>()

    /** The [RuntimeResourcePack] extension utilized for generating data & resource packs. */
    // lazily loaded as `instance` is loaded after these two properties
    open val pack by lazy { RegistrarPack(instance) }

    /** The content category containing content registrars. */
    open val content by lazy { ContentCategory(instance) }
}