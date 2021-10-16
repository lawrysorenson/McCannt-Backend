package DAO

import AuthToken
import java.sql.*

class AuthTokenDAO(var conn: Connection?) {

    /**
     * Inserts an AuthToken into the database; For Login/Register
     * @param token The AuthToken to be inserted
     */
    fun insert(token : AuthToken) {
        val sql = "INSERT INTO AuthToken (authToken, userID, timestamp) VALUES (?, ?, ?)"
        try {
            conn!!.prepareStatement(sql).use { stmt ->
                stmt.setString(1, token.authToken)
                stmt.setString(2, token.userID)
                stmt.setString(3, token.timestamp)
                stmt.executeUpdate()
            }
        } catch (ex: SQLException) {
            throw Exception("Error encountered while inserting authorization token into the database")
        }
    }

    /**
     * Searches for an AuthToken in the database
     * @param token The token being searched for
     * @return An AuthToken object of the AuthToken if found, else returns null
     */
    fun find(token: String): AuthToken? {
        var authToken: AuthToken
        var rs: ResultSet? = null
        val sql = "SELECT * FROM AuthToken WHERE authToken = ?;"
        try {
            conn!!.prepareStatement(sql).use { stmt ->
                stmt.setString(1, token)
                rs = stmt.executeQuery()
                if (rs!!.next()) {
                    authToken = AuthToken(
                        rs!!.getString("authToken"), rs!!.getString("userID"),
                        rs!!.getString("timestamp")
                    )
                    return authToken
                }
            }
        } catch (ex: SQLException) {
            ex.printStackTrace()
            throw Exception("Error encountered when finding token")
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

    /**
     * Deletes a single authtoken based on the token passed in
     * @param token Token to be deleted
     * @throws Exception
     */
    fun delete(token: String?) {
        val sql = "DELETE FROM AuthToken WHERE authToken = ?;"
        try {
            conn!!.prepareStatement(sql).use { stmt ->
                stmt.setString(1, token)
                stmt.executeUpdate()
            }
        } catch (ex: SQLException) {
            ex.printStackTrace()
            throw Exception("Error encountered while deleting token")
        }
    }

}