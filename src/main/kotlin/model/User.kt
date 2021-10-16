package model

class User (var id: Int, var username: String, var hashedPassword: String, var firstName: String?, var lastName: String?) {

    override fun equals(other: Any?)
        = (other is User)
            && id == other.id
            && username == other.username
            && firstName == other.firstName
            && lastName == other.lastName
            && hashedPassword == other.hashedPassword

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + username.hashCode()
        result = 31 * result + hashedPassword.hashCode()
        result = 31 * result + firstName.hashCode()
        result = 31 * result + lastName.hashCode()
        return result
    }

}