package net.axxal.services

import net.axxal.types.*
import java.util.UUID

object SitePostService {
    var posts: Array<SitePost> = arrayOf(SitePost("Debut Gig", "Live performance with four songs at Tuben Farsta!", null))

    fun getAll(): Array<SitePost> {
        return posts
    }

    fun getById(id: String): SitePost {
        return posts.first { p -> p.id.equals(id) } ?: throw NoSuchElementException("SitePost not found.")
    }

    fun save(newPost: SitePost): SitePost {
        posts += newPost
        return newPost
    }
}