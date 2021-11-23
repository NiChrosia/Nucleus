package nucleus.common.registrar.type.content

import net.minecraft.entity.player.PlayerInventory
import net.minecraft.screen.ScreenHandler
import net.minecraft.screen.ScreenHandlerContext
import net.minecraft.screen.ScreenHandlerType
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import nucleus.common.registrar.base.identity.IdentifyingRegistrar

open class ScreenTypeRegistrar(namespace: String) : IdentifyingRegistrar<ScreenHandlerType<*>>(namespace) {
    open fun <T : ScreenHandler> typeOf(constructor: (Int, PlayerInventory, ScreenHandlerContext) -> T): ScreenHandlerType<T> {
        return ScreenHandlerType { syncID, playerInventory ->
            constructor(syncID, playerInventory, ScreenHandlerContext.EMPTY)
        }
    }

    override fun publish(key: Identifier, value: ScreenHandlerType<*>): ScreenHandlerType<*> {
        return super.publish(key, value).also {
            Registry.register(Registry.SCREEN_HANDLER, key, value)
        }
    }
}