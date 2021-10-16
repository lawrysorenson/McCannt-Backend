package services

import dao.Database
import requests.StatUpdateRequest
import responses.Response
import requests.StatQueryRequest
import responses.StatQueryResponse

import dao.UserStatisticDAO

class StatisticService {
    fun updateStats(request: StatUpdateRequest): Response {
        val db = Database()

        return try {
            val conn = db.openConnection()
            val statDao = UserStatisticDAO(conn)
            statDao.insert(request.newStats)
            statDao.update(request.updatedStats)
            db.closeConnection(true)
            Response(true)
        } catch (e: Exception) {
            db.closeConnection(false)
            Response(false)
        }
    }

    fun getStats(request: StatQueryRequest): StatQueryResponse {
        val db = Database()

        return try {
            val conn = db.openConnection()
            val statDao = UserStatisticDAO(conn)
            val queriedStats = statDao.find(request.userID, request.srcLangID, request.targLangID)
            db.closeConnection(true)
            StatQueryResponse(true, queriedStats)
        } catch (e: Exception) {
            db.closeConnection(false)
            StatQueryResponse(false, ArrayList())
        }
    }
}