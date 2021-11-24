package nucleus.common.registrar.type.content

import net.minecraft.entity.player.PlayerInventory
import net.minecraft.screen.ScreenHandler
import net.minecraft.screen.ScreenHandlerContext
import net.minecraft.screen.ScreenHandlerType
import net.minecraft.util.registry.Registry
import nucleus.common.registrar.base.vanilla.SimpleVanillaRegistrar

open class ScreenTypeRegistrar(namespace: String) : SimpleVanillaRegistrar<ScreenHandlerType<*>>(namespace, Registry.SCREEN_HANDLER) {
    open fun <T : ScreenHandler> typeOf(constructor: (Int, PlayerInventory, ScreenHandlerContext) -> T): ScreenHandlerType<T> {
        return ScreenHandlerType { syncID, playerInventory ->
            constructor(syncID, playerInventory, ScreenHandlerContext.EMPTY)
        }
    }
}