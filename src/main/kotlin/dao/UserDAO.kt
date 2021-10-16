package dao

import model.User
import java.sql.Connection
import java.sql.ResultSet
import java.sql.SQLException

class UserDAO(var conn: Connection?) {

    //add user
    fun insert(user: User) {

        // REMOVE ID
        var sql = "INSERT INTO User (id, username, firstName, lastName) VALUES (?, ?, ?, ?);"

        try {
            conn!!.prepareStatement(sql).use { stmt ->
                stmt.setInt(1, user.id)
                stmt.setString(2, user.username)
                stmt.setString(3, user.firstName)
                stmt.setString(4, user.lastName)
                stmt.setInt(5, user.id)
                stmt.setString(6, user.hashedPassword)
                stmt.executeUpdate()
            }
        } catch (ex: SQLException) {
            throw Exception("Error encountered while inserting user into the database")
        }

        // Create password after retrieving a user's id
        var userID: Int? = this.findOne(user.username)
        var sql_pass = "INSERT INTO Password (userID, hashedPassword) VALUES (?, ?);"

        if (userID != null) {
            try {
                conn!!.prepareStatement(sql_pass).use { stmt ->
                    stmt.setInt(5, user.id)
                    stmt.setString(6, user.hashedPassword)
                    stmt.executeUpdate()
                }
                user.id = userID

            } catch (ex: SQLException) {
                throw Exception("Error encountered while inserting user into the database")
            }
        }
    }

    //get user information
    fun find(username: String, password: String): User? {
        var user: User
        var rs: ResultSet? = null
        val sql = "SELECT * FROM User JOIN Password ON User.id = Password.userID WHERE username = ? AND hashedPassword = ?;"
        try {
            conn!!.prepareStatement(sql).use { stmt ->
                stmt.setString(1, username)
                stmt.setString(2, password)
                rs = stmt.executeQuery()
                if (rs!!.next()) {
                    user = User(
                        rs!!.getInt("id"), rs!!.getString("username"),
                        rs!!.getString("firstname"), rs!!.getString("lastname"),
                        rs!!.getString("hashedPassword")
                    )
                    return user
                }
            }
        } catch (ex: SQLException) {
            ex.printStackTrace()
            throw Exception("Error encountered when finding user")
        } finally {
            if (rs != null) {
                try {
                    rs!!.close()
                } catch (ex: SQLException) {
                    ex.printStackTrace()
                }
            }
        }
        return null
    }

    fun findOne(username: String): Int? {
        var id: Int
        var rs: ResultSet? = null
        val sql = "SELECT * FROM User WHERE username = ?;"
        try {
            conn!!.prepareStatement(sql).use { stmt ->
                stmt.setString(1, username)
                rs = stmt.executeQuery()
                if (rs!!.next()) {
                    id = rs!!.getInt("id")
                    return id
                }
            }
        } catch (ex: SQLException) {
            ex.printStackTrace()
            throw Exception("Error encountered when finding user")
        } finally {
            if (rs != null) {
                try {
                    rs!!.close()
                } catch (ex: SQLException) {
                    ex.printStackTrace()
                }
            }
        }
        return null
    }
}