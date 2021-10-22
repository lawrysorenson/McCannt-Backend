package model

class UserLanguage (var relationType: Int, var userID: Int, var languageID: String) {
    companion object {
        const val PRIMARY = 1
        const val SECONDARY = 0
    }

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
