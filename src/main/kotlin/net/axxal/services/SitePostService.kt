package net.axxal.services

import net.axxal.types.*
import java.util.UUID

object SitePostService {
    var posts: ArrayList<SitePost> = arrayListOf<SitePost>(
        SitePost("Debut Gig", "Live performance with four songs at Tuben Farsta!", null)
    )

    fun getAll(): ArrayList<SitePost> {
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

    // Search for post with matching id and remove it from the list if found
    // Return null if no matching element is found
    fun delete(id: String): SitePost? {
        val post: SitePost = getById(id) ?: return null
        posts.remove(post)
        return post
    }

    // Search array with post id, return the post's index if found, else return null
    private fun getIndex(id: String): Int? {
        for (index in posts.indices) {
            if (!posts[index].id.equals(id)) continue
            return index
        }
        return null
    }
}