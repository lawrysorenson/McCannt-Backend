package DataAccess

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

/**
 * Database object for controlling general database operations
 */
class Database {
    private var conn: Connection? = null

    /**
     * Opens a connection to the database
     * @return A connection that can be used by the data access objects
     * @throws DataAccessException
     */
    fun openConnection(): Connection? {
        try {
            val CONNECTION_URL = "jdbc:sqlite:familymap.sqlite"
            conn = DriverManager.getConnection(CONNECTION_URL)
            conn?.setAutoCommit(false)
        } catch (ex: SQLException) {
            ex.printStackTrace()
            throw Exception("Unable to open connection to database");
        }
        return conn
    }

    /**
     * Gets the connection variable to be passed into DOAs
     * @return The connection opened
     * @throws DataAccessException
     */
    val connection: Connection?
        get() = if (conn == null) {
            openConnection()
        } else {
            conn
        }

    /**
     * Closes the database connection
     * @param commit Determines whether the changes made to the database are committed or rolled back.
     * @throws DataAccessException
     */
    fun closeConnection(commit: Boolean) {
        conn = try {
            if (commit) {
                conn!!.commit()
            } else {
                conn!!.rollback()
            }
            conn!!.close()
            null
        } catch (ex: SQLException) {
            ex.printStackTrace()
            throw Exception("Unable to close database connection")
        }
    }

    /**
     * Clears a given table; utilized by the unit tests to temporarily clear a table for testing
     * @param tableName
     * @throws DataAccessException
     */
    fun clearTables(tableName: String) {
        try {
            conn!!.createStatement().use { stmt ->
                val sql = "DELETE FROM $tableName"
                stmt.executeUpdate(sql)
            }
        } catch (e: SQLException) {
            throw Exception("SQL Error encountered while clearing tables")
        }
    }
}