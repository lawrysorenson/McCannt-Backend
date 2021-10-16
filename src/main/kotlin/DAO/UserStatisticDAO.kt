package DAO

import UserStat
import java.sql.Connection

class UserStatisticDAO(var conn: Connection?) {

    //update statistic
    fun update(updated: Array<UserStat>) {

    }

    //get statistic
    fun find(id: Int): Array<UserStat>? {
        return null
    }
}