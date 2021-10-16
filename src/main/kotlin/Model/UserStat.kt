class UserStat(var userID: Int, var mappingID: Int, var srcLangID: String, var targLangID: String, var statCount: Int) {

    override fun equals(other: Any?)
        = (other is UserStat)
            && userID == other.userID
            && mappingID == other.mappingID
            && srcLangID == other.srcLangID
            && targLangID == other.targLangID
            && statCount == other.statCount

    override fun hashCode(): Int {
        var result = userID.hashCode()
        result = 31 * result + mappingID.hashCode()
        result = 31 * result + srcLangID.hashCode()
        result = 31 * result + targLangID.hashCode()
        result = 31 * result + statCount
        return result
    }

    override fun toString(): String {
        return "($userID, $mappingID, $srcLangID, $targLangID, $statCount)"
    }
}