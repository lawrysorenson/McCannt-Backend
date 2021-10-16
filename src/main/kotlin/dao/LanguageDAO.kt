package dao

import model.Language
import java.sql.Connection
import java.sql.ResultSet
import java.sql.SQLException

class LanguageDAO(var conn: Connection?) {

    /**
     * Retrieves all languages from the database;
     */

    fun get(): MutableList<Language> {

        val languages: MutableList<Language> = ArrayList()
        var language: Language

        var rs: ResultSet? = null
        val sql = "SELECT * FROM Language;"

        try {
            conn!!.prepareStatement(sql).use { stmt ->
                rs = stmt.executeQuery()
                while (rs!!.next()) {
                     language = Language(
                        rs!!.getString("id"), rs!!.getString("name")
                    )
                    languages.add(language)
                }
                return languages
            }
        } catch (ex: SQLException) {
            ex.printStackTrace()
            throw Exception("Error encountered when retrieving languages")
        } finally {
            if (rs != null) {
                try {
                    rs!!.close()
                } catch (ex: SQLException) {
                    ex.printStackTrace()
                }
            }
        }
    }

}