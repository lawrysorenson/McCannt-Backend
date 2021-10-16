package Responses

import Language

class LanguageResponse(successInput: Boolean, languageInput: MutableList<Language>?) {

    var success: Boolean = successInput
    var languages: MutableList<Language>? = languageInput

    fun isSuccess(): Boolean {
        return success
    }

    @JvmName("getLanguages1")
    fun getLanguages(): MutableList<Language>? {
        return languages
    }

}