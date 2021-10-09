class UserStat(var userID: String, var mappingID: String, var srcLangID: String, var targLangID: String, var statCount: Int) {

    override fun equals(other: Any?)
        = (other is UserStat)
            && userID == other.userID
            && mappingID == other.mappingID
            && srcLangID == other.srcLangID
            && targLangID == other.targLangID
            && statCount == other.statCount

}