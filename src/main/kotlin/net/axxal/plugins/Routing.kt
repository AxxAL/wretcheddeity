package net.axxal.plugins

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import net.axxal.services.SitePostService
import net.axxal.types.ApiMessage
import net.axxal.types.SitePost
import java.util.UUID

fun Application.configureRouting() {
    routing {

        // Root of API Version 1.0
        route("/api/v1") {

            // Root of post route
            route("/post") {

                // Endpoint returns all saved site posts
                get("/all") {
                    val posts: Array<SitePost> = SitePostService.getAll()
                    call.respond(posts)
                }
                
                // Endpoint searches for site post with provided id and returns it if found
                get("/{id?}") {
                    val id: String = call.parameters["id"] ?:
                        return@get call.respond(ApiMessage(false, "Bad Request"))
                    
                    val post: SitePost = SitePostService.getById(id) ?:
                        return@get call.respond(ApiMessage(false, "Not Found"))

                    call.respond(post)
                }

                // Endpoint attempts to create a new sitepost
                post("/") {
                    val newPost: SitePost = call.receive<SitePost>()
                    val result: SitePost = SitePostService.save(newPost)
                    call.respond(result)
                }

            }

        }
        
    }
}
