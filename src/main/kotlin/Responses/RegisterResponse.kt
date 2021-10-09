package Responses

class RegisterResponse(successInput: Boolean) {

    //to do return json files for languages

    var success: Boolean = successInput

    fun isSuccess(): Boolean {
        return success
    }

}