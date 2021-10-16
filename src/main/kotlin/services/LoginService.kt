package services

import requests.LoginRequest
import responses.LoginResponse
import dao.*
import model.AuthToken

class LoginService {
    fun login(req: LoginRequest): LoginResponse {
        val db = Database()

        return try {
            val conn = db.openConnection()

            val udao = UserDAO(conn)

            //TODO: hash password in req
            val user = udao.find(req.getUsername(), req.getPassword())

            if (user == null) //user does not exist/wrong password
            {
                db.closeConnection(false)
                return LoginResponse(false, null)
            }

            //Correct credentials, create auth token
            val token = AuthToken(user.id)

            val tdao = AuthTokenDAO(conn)
            tdao.insert(token)

            db.closeConnection(true)

            LoginResponse(true, token)

        } catch (e: Exception) {
            db.closeConnection(false)
            LoginResponse(false, null)
        }
    }
}