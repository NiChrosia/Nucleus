package nucleus.common.builtin.division.content

import net.minecraft.entity.player.PlayerInventory
import net.minecraft.screen.ScreenHandler
import net.minecraft.screen.ScreenHandlerContext
import net.minecraft.screen.ScreenHandlerType
import net.minecraft.util.registry.Registry
import nucleus.common.builtin.division.ModRoot
import nucleus.common.registrar.type.VanillaRegistrar

open class ScreenHandlerRegistrar<R : ModRoot<R>>(root: R) : VanillaRegistrar<ScreenHandlerType<*>, R>(root, Registry.SCREEN_HANDLER) {
    open fun <T : ScreenHandler> typeOf(constructor: (Int, PlayerInventory, ScreenHandlerContext) -> T): ScreenHandlerType<T> {
        return ScreenHandlerType { syncID, playerInventory ->
            constructor(syncID, playerInventory, ScreenHandlerContext.EMPTY)
        }
    }
}