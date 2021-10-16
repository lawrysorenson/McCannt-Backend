package DAO

import Language
import java.sql.Connection

class LanguageDAO(var conn: Connection?) {

    //get languages
    fun get(): Array<Language> {
        return arrayOf<Language>()
    }

}