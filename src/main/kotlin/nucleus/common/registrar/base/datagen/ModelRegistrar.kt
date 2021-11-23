package nucleus.common.registrar.base.datagen

import net.devtech.arrp.api.RuntimeResourcePack
import net.devtech.arrp.json.models.JModel
import net.minecraft.util.Identifier

open class ModelRegistrar(namespace: String, pack: RuntimeResourcePack) : PackRegistrar<JModel>(pack, namespace) {
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