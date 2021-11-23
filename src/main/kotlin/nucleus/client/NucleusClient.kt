package nucleus.client

import net.fabricmc.api.ClientModInitializer
import nucleus.client.registrar.builtin.MinecraftClientCategory

@Suppress("unused")
object NucleusClient : ClientModInitializer {
    override fun onInitializeClient() {
        MinecraftClientCategory.launch()
    }
}