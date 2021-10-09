package Responses

class StatisticResponse(successInput: Boolean) {

    var success: Boolean = successInput

    fun isSuccess(): Boolean {
        return success
    }

}