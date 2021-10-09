package Services

import Responses.LanguageResponse

class LanguageService {
    fun getLanguages(): LanguageResponse {
        //Implement DAO
        val response = LanguageResponse(true, arrayOf("English", "Spanish"), arrayOf("eng", "spa"))
        return response
    }
}