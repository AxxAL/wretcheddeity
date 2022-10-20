package net.axxal.types

import kotlinx.serialization.*
import java.util.UUID
import java.time.LocalDateTime

@Serializable
data class SitePost(val title: String, val message: String, val image: String?) {
    val id: String = UUID.randomUUID().toString()
    val date: String = LocalDateTime.now().toString()
}