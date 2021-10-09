class UserLanguage (var relationType: Int, var userID: String, var languageID: String) {

    override fun equals(other: Any?)
        = (other is UserLanguage)
            && relationType == other.relationType
            && userID == other.userID
            && languageID == other.languageID

}