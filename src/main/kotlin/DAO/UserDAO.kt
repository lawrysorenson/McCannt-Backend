package DAO

import User
import java.sql.Connection

class UserDAO(var conn: Connection?) {

    //add user
    fun insert(user: User) {

    }

    //get user information
    fun find(username: String): User? {
        return null
    }
}