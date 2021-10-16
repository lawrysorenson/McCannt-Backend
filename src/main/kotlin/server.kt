import services.*
import requests.*
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.content.*
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.gson.*
import io.ktor.http.content.static
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "127.0.0.1") {
        install(ContentNegotiation) {
            gson()
        }
        routing {
            get("/language") {
                val service = LanguageService()
                val res = service.getLanguages()
                call.respond(res)
            }
            post("/login") {
                val req = call.receive<LoginRequest>()
                val service = LoginService()
                val res = service.login(req)
                call.respond(res)
            }
            post("/register") {
                val req = call.receive<RegisterRequest>()
                val service = RegisterService()
                val res = service.register(req)
                call.respond(res)
            }
            post("/stats") {
                val req = call.receive<StatisticRequest>()
                val service = StatisticService()
                val res = service.getStatistics(req)
                call.respond(res)
            }
            static("jsons") {
                files("src/main/resources/jsons")
            }
        }
    }.start(wait = true)
}