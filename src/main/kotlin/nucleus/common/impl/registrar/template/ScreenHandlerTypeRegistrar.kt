package nucleus.common.impl.registrar.template

import net.minecraft.entity.player.PlayerInventory
import net.minecraft.screen.ScreenHandler
import net.minecraft.screen.ScreenHandlerType
import net.minecraft.util.registry.Registry
import nucleus.common.impl.registrar.MinecraftRegistrar

open class ScreenHandlerTypeRegistrar(namespace: String) : MinecraftRegistrar<ScreenHandlerType<*>>(Registry.SCREEN_HANDLER, namespace) {
    // provide a public method, as the constructor normally requires an access widener
    fun <S : ScreenHandler> typeOf(factory: (Int, PlayerInventory) -> S): ScreenHandlerType<S> {
        return ScreenHandlerType(factory)
    }
}