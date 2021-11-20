package dao

import model.UserStats
import org.litote.kmongo.*

class UserStatisticDAO() {
    val clientURL = "mongodb://localhost:27017";
    val databaseName = "mccant";

    //update statistic
    fun update(updated: UserStats) {
        val client = KMongo.createClient(clientURL) //get com.mongodb.MongoClient new instance
        val database = client.getDatabase(databaseName) //normal java driver usage
        val col = database.getCollection<UserStats>() //KMongo extension method

        col.deleteOne(UserStats::userID eq updated.userID, UserStats::srcLangID eq updated.srcLangID, UserStats::targLangID eq updated.targLangID)
        col.insertOne(updated)
    }

    //get statistic
    fun find(userID: Int, srcLangID: String, targLangID: String): UserStats? {
        val client = KMongo.createClient(clientURL) //get com.mongodb.MongoClient new instance
        val database = client.getDatabase(databaseName) //normal java driver usage
        val col = database.getCollection<UserStats>() //KMongo extension method

        return col.findOne(UserStats::userID eq userID, UserStats::srcLangID eq srcLangID, UserStats::targLangID eq targLangID)
    }
}
