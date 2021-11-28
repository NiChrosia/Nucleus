package nucleus.common.builtin.division

import net.devtech.arrp.api.RRPCallback
import net.devtech.arrp.api.RuntimeResourcePack
import net.devtech.arrp.json.lang.JLang

/** An extension of [RuntimeResourcePack] that contains an english lang value, to be added at `packAddition`. */
open class RegistrarPack<R : ModRoot<R>>(root: R) : RuntimeResourcePack by RuntimeResourcePack.create("${root.id}:main") {
    val english = JLang()

    init {
        root.dispatcher.packAddition.listeners.add {
            addLang(root.identify("en_us"), english)

            RRPCallback.AFTER_VANILLA.register { packs ->
                packs.add(this@RegistrarPack)
            }
        }
    }
}