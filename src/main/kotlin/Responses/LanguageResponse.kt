package Responses

import Language

class LanguageResponse(successInput: Boolean, languageInput: Array<Language>?) {

    var success: Boolean = successInput
    var languages: Array<Language>? = languageInput

    fun isSuccess(): Boolean {
        return success
    }

    @JvmName("getLanguages1")
    fun getLanguages(): Array<Language>? {
        return languages
    }

}