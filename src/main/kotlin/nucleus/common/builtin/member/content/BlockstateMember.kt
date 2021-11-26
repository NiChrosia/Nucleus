package nucleus.common.builtin.member.content

import net.devtech.arrp.json.blockstate.JBlockModel
import net.devtech.arrp.json.blockstate.JState
import net.devtech.arrp.json.blockstate.JVariant
import net.minecraft.util.Identifier
import nucleus.common.builtin.division.ModRoot
import nucleus.common.extension.within

interface BlockstateMember<R : ModRoot<R>> {
    val root: R
    val key: Identifier

    fun staticBlockstate(): JState {
        val model = JBlockModel(key.within("block"))

        val variant = JVariant()
        variant.put("", model)

        val state = JState()
        state.add(variant)

        return state
    }

    fun blockstate(provider: () -> JState) {
        root.register.listeners.add {
            pack.addBlockState(provider(), key)
        }
    }
}