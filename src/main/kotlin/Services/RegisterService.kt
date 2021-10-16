package Services

import Requests.LoginRequest
import Requests.RegisterRequest
import Responses.LoginResponse
import Responses.RegisterResponse

class RegisterService {
    fun register(request: RegisterRequest): RegisterResponse {
        //Implement DAO
        val response = RegisterResponse(true, null)
        return response
    }
}