class Password(var userID: String, var hashedPassword: String) {

    override fun equals(other: Any?)
        = (other is Password)
            && userID == other.userID
            && hashedPassword == other.hashedPassword

}