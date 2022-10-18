package net.axxal.services

import net.axxal.types.*

object SitePostService {
    val posts: Array<SitePost> = arrayOf(SitePost(1, "Debut Gig", "Live performance with four songs at Tuben Farsta!", null))

    fun getAll(): Array<SitePost> {
        return posts
    }
}