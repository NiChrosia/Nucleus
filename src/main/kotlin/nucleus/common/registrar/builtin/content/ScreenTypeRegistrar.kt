package nucleus.common.registrar.builtin.content

import net.minecraft.entity.player.PlayerInventory
import net.minecraft.screen.ScreenHandler
import net.minecraft.screen.ScreenHandlerContext
import net.minecraft.screen.ScreenHandlerType
import nucleus.common.registrar.type.identity.IdentifyingRegistrar

open class ScreenTypeRegistrar(namespace: String) : IdentifyingRegistrar<ScreenHandlerType<*>>(namespace) {
    fun <T : ScreenHandler> typeOf(constructor: (Int, PlayerInventory, ScreenHandlerContext) -> T): ScreenHandlerType<T> {
        return ScreenHandlerType { syncID, playerInventory ->
            constructor(syncID, playerInventory, ScreenHandlerContext.EMPTY)
        }
    }
}