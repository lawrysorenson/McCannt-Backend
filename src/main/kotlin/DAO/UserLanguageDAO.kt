package DAO

import UserLanguage
import java.sql.Connection
import java.sql.ResultSet
import java.sql.SQLException

class UserLanguageDAO(var conn: Connection?) {

    //add user language
    fun insert(add: UserLanguage) {
        //INSERT INTO UserLanguage(userID, relationType, languageID) VALUES (1, 1, 'eng'), (1, 0, 'spa'); -- 0 Secondary 1 Primary
        var sql = "INSERT INTO UserLanguage (userID, relationType, languageID) VALUES (?, ?, ?)"
        try {
            conn!!.prepareStatement(sql).use { stmt ->
                stmt.setString(1, add.userID)
                stmt.setInt(2, add.relationType)
                stmt.setString(3, add.languageID)
                stmt.executeUpdate()
            }
        } catch (ex: SQLException) {
            throw Exception("Error encountered while inserting user language into the database")
        }
    }

    //get user languages
    fun find(id: String): MutableList<UserLanguage>? {

        val userLanguages: MutableList<UserLanguage> = ArrayList()
        var userLanguage: UserLanguage

        var rs: ResultSet? = null
        val sql = "SELECT * FROM UserLanguage WHERE userID = ?;"

        try {
            conn!!.prepareStatement(sql).use { stmt ->
                stmt.setString(1, id)
                rs = stmt.executeQuery()
                while (rs!!.next()) {
                    userLanguage = UserLanguage(
                        rs!!.getInt("relationType"), rs!!.getString("userID"), rs!!.getString("languageID")
                    )
                    userLanguages.add(userLanguage)
                }
                return userLanguages
            }
        } catch (ex: SQLException) {
            ex.printStackTrace()
            throw Exception("Error encountered when retrieving user languages")
        } finally {
            if (rs != null) {
                try {
                    rs!!.close()
                } catch (ex: SQLException) {
                    ex.printStackTrace()
                }
            }
        }
        return userLanguages
    }
}