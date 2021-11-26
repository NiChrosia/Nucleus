package nucleus.common.builtin.division.content

import net.minecraft.util.Identifier
import nucleus.common.builtin.division.ModRoot
import nucleus.common.registrar.Registrar

open class TagRegistrar<R : ModRoot<R>>(root: R) : Registrar<Identifier, Tag<R>, R>(root) {
    open fun tagOf(id: Identifier, values: MutableList<Identifier> = mutableListOf()): Tag<R> {
        return Tag(root, id, values)
    }
}