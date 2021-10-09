class User (var id: String, var username: String, var hashedPassword: String, var firstName: String, var lastName: String) {

    override fun equals(other: Any?)
        = (other is User)
            && id == other.id
            && username == other.username
            && firstName == other.firstName
            && lastName == other.lastName
            && hashedPassword == other.hashedPassword

}