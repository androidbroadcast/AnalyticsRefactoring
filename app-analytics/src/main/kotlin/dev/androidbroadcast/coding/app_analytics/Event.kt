package dev.androidbroadcast.coding.app_analytics

interface Event {
    val name: String
    val params: Map<String, Any>?
        get()  = null

    open class Simple(
        override val name: String,
        override val params: Map<String, Any>? = null
    ): Event {

        override fun toString(): String {
            return "Event(name='$name', param=$params)"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as Simple
            return name == other.name && params == other.params
        }

        override fun hashCode() = name.hashCode()

    }

    companion object {

        operator fun invoke(
            name: String,
            param: Map<String, Any>? = null
        ): Event {
            return Simple(name, param)
        }
    }
}