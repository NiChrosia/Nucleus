package nucleus.testmod

import net.fabricmc.api.ModInitializer
import nucleus.testmod.registrar.NBlockEntityTypeRegistrar
import nucleus.testmod.registrar.NBlockRegistrar
import nucleus.testmod.registrar.NItemGroupRegistrar
import nucleus.testmod.registrar.NItemRegistrar

object Nucleus : ModInitializer {
    const val namespace = "nucleus"

    val blocks = NBlockRegistrar(namespace)
    val blockEntityTypes = NBlockEntityTypeRegistrar(namespace)
    val itemGroups = NItemGroupRegistrar(namespace)
    val items = NItemRegistrar(namespace)

    override fun onInitialize() {
        // do nothing, as the constructor already does everything necessary
    }
}