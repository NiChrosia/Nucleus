package nucleus.client.builtin.division

import nucleus.client.builtin.division.content.ClientContentCategory
import nucleus.common.division.RegistrarRoot

abstract class ClientModRoot<R : ClientModRoot<R>>(id: String) : RegistrarRoot<R>(id) {
    // lazy because `instance` isn't initialized yet
    open val content by lazy { ClientContentCategory(instance) }
}