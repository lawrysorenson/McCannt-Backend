package Services

import Requests.LanguageRequest
import Responses.LanguageResponse

class LanguageService {
    fun getLanguages(request: LanguageRequest): LanguageResponse {
        //Implement DAO
        val response = LanguageResponse(true, arrayOf("English", "Spanish"))
        return response
    }
}