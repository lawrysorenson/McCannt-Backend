package services

import dao.Database
import requests.StatUpdateRequest
import responses.Response
import requests.StatQueryRequest
import responses.StatQueryResponse
import model.UserStats

import dao.UserStatisticDAO

class StatisticService {
    fun updateStats(request: StatUpdateRequest): Response {
        return try {
            val statDao = UserStatisticDAO()
            statDao.update(request.stats)
            Response(true)
        } catch (e: Exception) {
            Response(false)
        }
    }

    fun getStats(request: StatQueryRequest): StatQueryResponse {

        val default = UserStats(request.userID, request.srcLangID, request.targLangID, emptyMap<Int, Int>())
        return try {
            val statDao = UserStatisticDAO()
            val queriedStats = statDao.find(request.userID, request.srcLangID, request.targLangID)
            StatQueryResponse(true, if (queriedStats==null) default else queriedStats)
        } catch (e: Exception) {
            StatQueryResponse(false, default)
        }
    }
}