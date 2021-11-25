package nucleus.common.registrar.type.tag

import net.minecraft.util.Identifier

abstract class TagEntry(
    val id: Identifier,
    entries: MutableList<Identifier> = mutableListOf()
) : MutableList<Identifier> by entries {
    abstract val folder: String
}