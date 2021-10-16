package model

class Password(var userID: Int, var hashedPassword: String) {

    override fun equals(other: Any?)
        = (other is Password)
            && userID == other.userID
            && hashedPassword == other.hashedPassword

    override fun hashCode(): Int {
        var result = userID
        result = 31 * result + hashedPassword.hashCode()
        return result
    }

}