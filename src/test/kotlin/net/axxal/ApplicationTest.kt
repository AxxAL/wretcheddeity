package axxal.net

import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.testing.*
import net.axxal.types.SitePost
import kotlin.test.Test

class ApplicationTest {

    @Test
    fun testPostCustomer() = testApplication {
        val client = createClient {
            install(ContentNegotiation) {
                json()
            }
        }
        val response = client.post("/customer") {
            contentType(ContentType.Application.Json)
            setBody(SitePost(2, "Second gig!", "Second ever gig, performed at Arena Satteliten", null))
        }
    }
}