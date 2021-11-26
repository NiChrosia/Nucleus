package nucleus.common.builtin.member.content

import net.minecraft.util.Identifier
import nucleus.common.builtin.division.ModRoot

interface TransitionMember<R : ModRoot<R>> {
    val root: R
    val key: Identifier

    fun old(vararg ids: Identifier) {
        ids.forEach {
            mappings[it] = key
        }
    }

    companion object {
        @JvmField
        val mappings = mutableMapOf<Identifier, Identifier>()
    }
}