package model

class UserLanguage (var relationType: Int, var userID: String, var languageID: String) {

    override fun equals(other: Any?)
        = (other is UserLanguage)
            && relationType == other.relationType
            && userID == other.userID
            && languageID == other.languageID

    override fun hashCode(): Int {
        var result = relationType
        result = 31 * result + userID.hashCode()
        result = 31 * result + languageID.hashCode()
        return result
    }

}