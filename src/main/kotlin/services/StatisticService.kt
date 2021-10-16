package services

import requests.StatisticRequest
import responses.StatisticResponse

class StatisticService {
    fun getStatistics(request: StatisticRequest): StatisticResponse {
        //Implement DAO
        val response = StatisticResponse(true)
        return response
    }
}