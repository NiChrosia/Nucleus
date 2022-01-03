@file:Suppress("DEPRECATION")

package nucleus.common.builtin.division

import net.devtech.arrp.api.RRPCallback
import net.devtech.arrp.api.RuntimeResourcePack
import net.devtech.arrp.impl.RuntimeResourcePackImpl
import net.devtech.arrp.json.lang.JLang
import net.minecraft.util.Identifier
import nucleus.common.phase.Phase

/** An extension of [RuntimeResourcePack] that contains an english lang value, to be added at `packAddition`. */
open class RegistrarPack<R : ModRoot<R>>(phase: Phase<R, Phase.Listener<R>>, namespace: String) : RuntimeResourcePackImpl(Identifier(namespace, "main")) {
    open val english = JLang()

    init {
        phase.listeners.add {
            addLang(it.identify("en_us"), english)

            RRPCallback.AFTER_VANILLA.register { packs ->
                packs.add(this@RegistrarPack)
            }
        }
    }
}