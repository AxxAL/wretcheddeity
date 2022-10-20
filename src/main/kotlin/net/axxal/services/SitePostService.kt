package net.axxal.services

import net.axxal.types.*
import java.util.UUID

object SitePostService {
    var posts: Array<SitePost> = arrayOf(SitePost("Debut Gig", "Live performance with four songs at Tuben Farsta!", null))

    fun getAll(): Array<SitePost> {
        return posts
    }

    fun getById(id: String): SitePost? {
        return try {
            posts.first { p -> p.id.equals(id) }
        } catch (e: NoSuchElementException) {
            return null
        }
    }

    fun save(newPost: SitePost): SitePost {
        posts += newPost
        return newPost
    }
}