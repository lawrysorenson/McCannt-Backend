package Responses

import AuthToken

class LoginResponse(successInput: Boolean, token: AuthToken?) {

    var success: Boolean = successInput
    var authToken: AuthToken? = token

    fun isSuccess(): Boolean {
        return success
    }

    fun getToken(): AuthToken? {
        return authToken
    }
}