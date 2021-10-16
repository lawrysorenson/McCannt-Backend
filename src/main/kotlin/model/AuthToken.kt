package model

import java.util.UUID
import java.lang.System

class AuthToken (var authToken: String, var userID: Int, var timestamp: Long) {

    constructor(user: Int): this("", user, 0) {
        val uuid = UUID.randomUUID()
        authToken = uuid.toString()
        timestamp = System.currentTimeMillis()
    }

    override fun equals(other: Any?)
        = (other is AuthToken)
            && authToken == other.authToken
            && userID == other.userID
            && timestamp == other.timestamp

    override fun hashCode(): Int {
        var result = authToken.hashCode()
        result = 31 * result + userID
        result = 31 * result + timestamp.hashCode()
        return result
    }
}
