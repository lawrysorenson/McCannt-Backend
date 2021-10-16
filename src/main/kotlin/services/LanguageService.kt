package services

import dao.LanguageDAO
import responses.LanguageResponse
import dao.Database

class LanguageService {
    fun getLanguages(): LanguageResponse {
        val db = Database()

        return try {
            val ldao = LanguageDAO(db.openConnection())

            LanguageResponse(true, ldao.get())
        } catch (e: Exception) {
            LanguageResponse(false, null)
        } finally {
            db.closeConnection(true)
        }
    }
}