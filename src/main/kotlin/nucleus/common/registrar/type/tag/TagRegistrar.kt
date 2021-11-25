package nucleus.common.registrar.type.tag

import net.devtech.arrp.json.tags.JTag
import net.minecraft.util.Identifier
import nucleus.common.extension.within
import nucleus.common.registrar.builtin.tag.TagGroup
import nucleus.common.registrar.type.IdRegistrar

abstract class TagRegistrar<T : TagEntry>(override val group: TagGroup) : IdRegistrar<T>(group) {
    override fun datagen() {
        super.datagen()

        content.forEach { (id, entry) ->
            val tag = JTag()
            entry.forEach(tag::add)

            group.pack.addTag(id.within(entry.folder), tag)
        }
    }

    abstract fun entryOf(id: Identifier, entries: MutableList<Identifier> = mutableListOf()): T

    open fun entryOf(path: String, entries: MutableList<Identifier> = mutableListOf()): T {
        return entryOf(group.identify(path), entries)
    }
}