package Services

import Requests.RegisterRequest
import Requests.StatisticRequest
import Responses.RegisterResponse
import Responses.StatisticResponse

class StatisticService {
    fun getStatistics(request: StatisticRequest): StatisticResponse {
        //Implement DAO
        val response = StatisticResponse(true)
        return response
    }
}