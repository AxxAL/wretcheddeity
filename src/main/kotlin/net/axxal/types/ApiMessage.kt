package net.axxal.types

import kotlinx.serialization.*

@Serializable
data class ApiMessage(val status: Boolean, val message: String)