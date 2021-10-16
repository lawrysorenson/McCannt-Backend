package services

import model.UserStat
import requests.StatUpdateRequest
import responses.Response
import requests.StatQueryRequest
import responses.StatQueryResponse

class StatisticService {
    fun updateStatistics(request: StatUpdateRequest): Response {
        val response = Response(true)
        return response
    }

    fun getStatistics(request: StatQueryRequest): StatQueryResponse {
        //Implement DAO
        val response = StatQueryResponse(true, ArrayList<UserStat>())
        return response
    }
}