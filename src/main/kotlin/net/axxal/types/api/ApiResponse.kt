package net.axxal.types.api

import io.ktor.http.*
import kotlinx.serialization.*

@Serializable
data class ApiResponse(val success: Boolean, val data: Any)