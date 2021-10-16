package DAO

import UserLanguage
import java.sql.Connection

class UserLanguageDAO(var conn: Connection?) {

    //add user language
    fun insert(add: UserLanguage) {

    }

    //get user languages
    fun find(id: Int): Array<UserLanguage>? {
        return null
    }
}