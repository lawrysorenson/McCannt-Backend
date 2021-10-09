package Services

import Requests.LanguageRequest
import Requests.LoginRequest
import Responses.LanguageResponse
import Responses.LoginResponse

class LoginService {
    fun login(request: LoginRequest): LoginResponse {
        //Implement DAO
        val response = LoginResponse(true)
        return response
    }
}