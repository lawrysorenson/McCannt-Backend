class Password(var userID: int, var hashedPassword: String) {

    override fun equals(other: Any?)
        = (other is Password)
            && userID == other.userID
            && hashedPassword == other.hashedPassword

}