package Services

import DAO.LanguageDAO
import Responses.LanguageResponse
import DataAccess.Database

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