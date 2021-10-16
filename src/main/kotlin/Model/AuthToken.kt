import java.util.UUID

class AuthToken (var authToken: String, var userID: Int, var timestamp: Long) {

    constructor(user: Int): this("", user, 0) {
        val uuid = UUID.randomUUID()
        authToken = uuid.toString()
        timestamp = uuid.timestamp()
    }

    override fun equals(other: Any?)
        = (other is AuthToken)
            && authToken == other.authToken
            && userID == other.userID
            && timestamp == other.timestamp
}
