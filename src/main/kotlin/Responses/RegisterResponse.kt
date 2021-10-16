package Responses

class RegisterResponse(successInput: Boolean) {
    //TODO: auth token
    //to do return json files for languages

    var success: Boolean = successInput

    fun isSuccess(): Boolean {
        return success
    }

}