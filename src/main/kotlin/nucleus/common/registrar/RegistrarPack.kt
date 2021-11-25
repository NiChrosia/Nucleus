package nucleus.common.registrar

import net.devtech.arrp.api.RRPCallback
import net.devtech.arrp.api.RuntimeResourcePack
import net.devtech.arrp.json.lang.JLang
import net.fabricmc.loader.api.FabricLoader
import net.minecraft.util.Identifier

open class RegistrarPack(val namespace: String) : RegistrarStage.User(), RuntimeResourcePack by RuntimeResourcePack.create("${namespace}:main") {
    val english = JLang()

    override fun datagen() {
        super.datagen()

        addLang(Identifier(namespace, "en_us"), english)
        
        if (FabricLoader.getInstance().isDevelopmentEnvironment) dump()

        RRPCallback.AFTER_VANILLA.register {
            it.add(this)
        }
    }
}