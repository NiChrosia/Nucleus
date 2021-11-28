package nucleus.common.builtin.member.content

import net.devtech.arrp.json.models.JModel
import net.minecraft.util.Identifier
import nucleus.common.builtin.division.ModRoot
import nucleus.common.extension.within

interface ModelMember<R : ModRoot<R>> {
    val root: R
    val key: Identifier

    val modelFolder: String

    fun model(provider: () -> JModel) {
        root.dispatcher.datagen.listeners.add {
            it.pack.addModel(provider(), key.within(modelFolder))
        }
    }
}