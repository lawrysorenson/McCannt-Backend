class AuthToken (var authToken: String, var userID: String, var timestamp: String) {

    override fun equals(other: Any?)
        = (other is AuthToken)
            && authToken == other.authToken
            && userID == other.userID
            && timestamp == other.timestamp
}
