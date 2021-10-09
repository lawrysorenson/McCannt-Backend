import io.ktor.application.*
import io.ktor.features.*
import io.ktor.html.respondHtml
import io.ktor.http.HttpStatusCode
import io.ktor.http.content.*
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import kotlinx.html.*
import io.ktor.gson.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "127.0.0.1") {
        install(ContentNegotiation) {
            gson()
        }
        routing {
            static("jsons") {
                files("src/main/resources/jsons")
            }
        }
    }.start(wait = true)
}