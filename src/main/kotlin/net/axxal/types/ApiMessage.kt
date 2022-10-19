package net.axxal.types

import kotlinx.serialization.*

@Serializable
data class ApiMessage(val success: Boolean, val message: String)