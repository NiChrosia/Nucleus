package nucleus.common.registrar.base.datagen

import net.devtech.arrp.api.RuntimeResourcePack
import net.devtech.arrp.json.lang.JLang
import net.minecraft.util.Identifier

open class LangRegistrar(namespace: String, pack: RuntimeResourcePack) : PackRegistrar<JLang>(pack, namespace) {
    override fun publish(key: Identifier, value: JLang): JLang {
        return super.publish(key, value).also {
            pack.addLang(key, value)
        }
    }
}