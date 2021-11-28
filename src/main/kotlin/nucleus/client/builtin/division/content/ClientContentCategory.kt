package nucleus.client.builtin.division.content

import nucleus.client.builtin.division.ClientModRoot
import nucleus.common.division.RegistrarCategory

open class ClientContentCategory<R : ClientModRoot<R>>(root: R) : RegistrarCategory<R>(root) {
    open val blockEntityRenderer = BlockEntityRendererRegistrar(root)
    open val screen = ScreenRegistrar(root)
}