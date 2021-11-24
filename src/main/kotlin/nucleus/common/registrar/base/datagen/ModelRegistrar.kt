package nucleus.common.registrar.base.datagen

import net.devtech.arrp.json.models.JModel
import net.minecraft.util.Identifier
import nucleus.common.datagen.lang.RegistrarPack
import nucleus.common.registrar.base.member.MemberRegistrar

open class ModelRegistrar(override val pack: RegistrarPack, namespace: String) : MemberRegistrar<JModel>(namespace), PackRegistrar {
    override fun publish(key: Identifier, value: JModel): JModel {
        return super.publish(key, value).also {
            pack.addModel(it, key)
        }
    }

    open fun publishItem(key: Identifier, value: JModel): JModel {
        return publish(Identifier(key.namespace, "items/${key.path}"), value)
    }

    open fun publishBlock(key: Identifier, value: JModel): JModel {
        return publish(Identifier(key.namespace, "blocks/${key.path}"), value)
    }
}