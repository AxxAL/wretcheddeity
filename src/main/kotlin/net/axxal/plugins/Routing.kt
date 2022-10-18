package net.axxal.plugins

import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*

import net.axxal.services.*
import net.axxal.types.*
import net.axxal.types.api.*

fun Application.configureRouting() {
    routing {
        get("/post/all") {
            val posts: Array<SitePost> = SitePostService.getAll()
            call.respond(
                ApiResponse(true, posts),
                HttpStatusCode.OK
            )
        }

        get("/post/{id?}") {
            val id = call.parameters["id"] ?:
                return@get call.respond(
                    ApiResponse(false, null),
                    HttpStatusCode.BadRequest
                )

            val sitePost: SitePost = SitePostService.getById(id.toInt()) ?:
                return@get call.respond(
                    ApiResponse(false, null),
                    HttpStatusCode.NotFound
                )

            call.respond(
                ApiResponse(true, sitePost),
                HttpStatusCode.OK
            )
        }
    }
}
