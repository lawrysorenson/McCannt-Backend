class UserLanguage (var relationshipID: String, var relationType: Int, var userID: String, var languageID: String) {

    override fun equals(other: Any?)
        = (other is UserLanguage)
            && relationshipID == other.relationshipID
            && relationType == other.relationType
            && userID == other.userID
            && languageID == other.languageID

}