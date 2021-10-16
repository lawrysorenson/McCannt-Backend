package Services

import Requests.LoginRequest
import Responses.LoginResponse
import DataAccess.*
import DAO.UserDAO
import User
import AuthToken
import DAO.AuthTokenDAO

class LoginService {
    fun login(req: LoginRequest): LoginResponse {
        val db = Database()

        return try {
            val conn = db.openConnection()

            val udao = UserDAO(conn)

            val user = udao.find(req.getUsername())

            //TODO: hash password in req
            if (user == null || user.hashedPassword == req.password) //user does not exist/wrong password
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