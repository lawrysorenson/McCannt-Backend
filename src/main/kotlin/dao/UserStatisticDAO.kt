package dao

import model.UserStat
import java.sql.*

class UserStatisticDAO(var conn: Connection?) {

    //update statistic
    fun update(updated: ArrayList<UserStat>) {
        val sql = "UPDATE UserStat SET statCount = ? WHERE (userID = ? AND mappingID = ? AND srcLangID = ? AND targLangID = ?)";

        try {
            val stmt = conn!!.prepareStatement(sql)

            var i = 0
            for (stat in updated) {
                stmt.setString(1, stat.statCount.toString())
                stmt.setString(2, stat.userID.toString())
                stmt.setString(3, stat.mappingID.toString())
                stmt.setString(4, stat.srcLangID)
                stmt.setString(5, stat.targLangID)
                stmt.addBatch()

                i++

                if (i % 1000 == 0 || i == updated.size) {
                    stmt.executeBatch()
                }
            }
        } catch (ex: SQLException) {
            throw Exception("Error encountered while inserting authorization token into the database")
        }
    }

    fun insert(newStats: ArrayList<UserStat>) {
        val sql = "INSERT INTO UserStat VALUES (?, ?, ?, ?, ?);"

        try {
            val stmt = conn!!.prepareStatement(sql)

            var i = 0
            for (newStat in newStats) {
                stmt.setString(1, newStat.userID.toString())
                stmt.setString(2, newStat.mappingID.toString())
                stmt.setString(3, newStat.srcLangID)
                stmt.setString(4, newStat.targLangID)
                stmt.setString(5, newStat.statCount.toString())
                stmt.addBatch()

                i++

                if (i % 1000 == 0 || i == newStats.size) {
                    stmt.executeBatch()
                }
            }
        } catch (ex: SQLException) {
            throw Exception("Error encountered while inserting authorization token into the database")
        }
    }

    //get statistic
    fun find(userID: Int, srcLangID: String, targLangID: String): ArrayList<UserStat> {
        var rs: ResultSet? = null
        val sql = "SELECT mappingID, statCount FROM UserStat WHERE (userID = ? AND srcLangID = ? AND targLangID = ?);"
        try {
            conn!!.prepareStatement(sql).use { stmt ->
                stmt.setString(1, userID.toString())
                stmt.setString(2, srcLangID)
                stmt.setString(3, targLangID)
                rs = stmt.executeQuery()

                val queriedStats = ArrayList<UserStat>()
                while (rs!!.next()) {
                    val stat = UserStat(
                        rs!!.getInt("userID"),
                        rs!!.getInt("mappingID"),
                        rs!!.getString("srcLangID"),
                        rs!!.getString("targLangID"),
                        rs!!.getInt("statCount")
                    )
                    queriedStats.add(stat)
                }
                return queriedStats
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
    }
}
