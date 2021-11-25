package nucleus.common.registrar.builtin.tag

import net.minecraft.util.Identifier
import nucleus.common.registrar.type.tag.TagRegistrar

open class BlockTagRegistrar(override val group: TagGroup) : TagRegistrar<BlockTagEntry>(group) {
    override fun entryOf(id: Identifier, entries: MutableList<Identifier>): BlockTagEntry {
        return BlockTagEntry(id, entries)
    }
}