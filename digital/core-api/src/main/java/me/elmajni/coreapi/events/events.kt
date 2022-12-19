package me.elmajni.coreapi.events

abstract class BaseEvent<T>(
        open val id: T
        )

data class CustomCreatedEvent(
        override val id : String,
        val name: String,
        val email: String,
        ):BaseEvent<String>(id)

data class CustomUpdatedEvent(
        override val id : String,
        val name: String,
        val email: String,
):BaseEvent<String>(id)