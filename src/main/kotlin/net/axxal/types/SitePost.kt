package net.axxal.types

import kotlinx.serialization.*

@Serializable
data class SitePost(val id: Int, val title: String, val message: String, val images: Array<String>?)