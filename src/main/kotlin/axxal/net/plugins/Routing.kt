package net.axxal.plugins

import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*

import net.axxal.services.*
import net.axxal.types.*

fun Application.configureRouting() {
    routing {
        get("/posts") {
            val posts: Array<SitePost> = SitePostService.getAll()
            call.respond(posts)
        }
    }
}
