package nucleus.common.datagen.lang

import net.devtech.arrp.api.RRPCallback
import net.devtech.arrp.api.RuntimeResourcePack
import net.devtech.arrp.json.lang.JLang
import net.fabricmc.fabric.api.event.Event
import net.minecraft.util.Identifier

/** A [RuntimeResourcePack] adapted to suit the needs of a registrar category, such as dynamic english lang generation,
 * models, blockstates, loot tables, etc. */
open class RegistrarPack(
    val namespace: String,
    val addEvent: Event<RRPCallback> = RRPCallback.AFTER_VANILLA
) : RuntimeResourcePack by RuntimeResourcePack.create("$namespace:main") {
    val english = JLang()

    open fun publish() {
        addLang(Identifier(namespace, "en_us"), english)

        addEvent.register {
            it.add(this)
        }
    }
}