package nucleus.common.registrar.builtin.tag

import net.minecraft.util.Identifier
import nucleus.common.registrar.type.tag.TagEntry

open class BlockTagEntry(id: Identifier, entries: MutableList<Identifier> = mutableListOf()) : TagEntry(id, entries) {
    override val folder = "blocks"
}