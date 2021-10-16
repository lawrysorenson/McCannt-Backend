package services

import dao.AuthTokenDAO
import dao.Database
import dao.UserDAO
import model.AuthToken
import model.User
import requests.RegisterRequest
import responses.RegisterResponse

class RegisterService {
    fun register(req: RegisterRequest): RegisterResponse {
        val db = Database()
        print("${req.firstName}, ${req.lastName}, ${req.username}, ${req.password}, ${req.primaryLanguage}\n")
        return try {
            val conn = db.openConnection()

            //TODO: hash password in req
            val user = User(0, req.username, req.firstName, req.lastName, req.password)

            val udao = UserDAO(conn)
            udao.insert(user)

            //Successful insert, create auth token
            val token = AuthToken(user.id)

            val tdao = AuthTokenDAO(conn)
            tdao.insert(token)

            db.closeConnection(true)
            RegisterResponse(true, token)

        } catch (e: Exception) {
            print(e.message)
            db.closeConnection(false)
            RegisterResponse(false, null)
        }
    }
}