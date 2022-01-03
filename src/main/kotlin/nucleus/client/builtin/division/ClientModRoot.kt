package nucleus.client.builtin.division

import nucleus.client.builtin.division.content.ClientContentCategory
import nucleus.common.division.RegistrarRoot

abstract class ClientModRoot<R : ClientModRoot<R>>(id: String) : RegistrarRoot<R>(id) {
    abstract val content: ClientContentCategory<R>
}