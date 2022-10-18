package net.axxal.plugins

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import net.axxal.services.SitePostService
import net.axxal.types.ApiMessage
import net.axxal.types.SitePost

fun Application.configureRouting() {
    routing {
        get("/post/all") {
            val posts: Array<SitePost> = SitePostService.getAll()
            call.respond(posts)
        }

        get("/post/{id?}") {
            val id = call.parameters["id"] ?:
                return@get call.respond(ApiMessage(false, "Bad Request"))

            val sitePost: SitePost = SitePostService.getById(id.toInt()) ?:
                return@get call.respond(ApiMessage(false, "Not Found"))

            call.respond(sitePost)
        }

        post("/post") {
            val newPost = call.receive<SitePost>()
            SitePostService.save(newPost)
            call.respond(newPost)
        }
    }
}
