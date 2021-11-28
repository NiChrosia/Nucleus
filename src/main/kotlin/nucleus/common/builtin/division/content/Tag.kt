package nucleus.common.builtin.division.content

import net.devtech.arrp.json.tags.JTag
import net.minecraft.util.Identifier
import nucleus.common.builtin.division.ModRoot

data class Tag<R : ModRoot<R>>(val root: R, val id: Identifier, val values: MutableList<Identifier> = mutableListOf()) {
    init {
        root.dispatcher.datagen.listeners.add {
            val jTag = JTag()
            values.forEach(jTag::add)

            it.pack.addTag(this@Tag.id, jTag)
        }
    }
}