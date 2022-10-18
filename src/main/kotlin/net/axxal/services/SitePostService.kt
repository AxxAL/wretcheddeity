package net.axxal.services

import net.axxal.types.*

object SitePostService {
    val posts: Array<SitePost> = arrayOf(SitePost(1, "Debut Gig", "Live performance with four songs at Tuben Farsta!", null))

    fun getAll(): Array<SitePost> {
        return posts
    }

    fun getById(id: Int): SitePost? {
        try {
            return posts.first { p -> p.id == id }
        } catch (e: NoSuchElementException) {
            return null
        }
    }
}