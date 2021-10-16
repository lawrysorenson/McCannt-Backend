package services

import requests.RegisterRequest
import responses.RegisterResponse

class RegisterService {
    fun register(request: RegisterRequest): RegisterResponse {
        //Implement DAO
        val response = RegisterResponse(true)
        return response
    }
}