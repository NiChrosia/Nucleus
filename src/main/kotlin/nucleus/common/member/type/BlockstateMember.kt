package nucleus.common.member.type

import net.devtech.arrp.json.blockstate.JBlockModel
import net.devtech.arrp.json.blockstate.JState
import net.devtech.arrp.json.blockstate.JVariant
import net.minecraft.block.Block
import net.minecraft.util.Identifier
import nucleus.common.extension.within
import nucleus.common.member.Member
import nucleus.common.registrar.builtin.content.BlockRegistrar

interface BlockstateMember<T : Block> {
    val registrar: BlockRegistrar
    val registrationListeners: MutableList<Member<Identifier, Block, T>.() -> Unit>
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
        registrationListeners.add {
            registrar.group.pack.addBlockState(provider(), key)
        }
    }
}