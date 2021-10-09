package Responses

class LanguageResponse(successInput: Boolean, languageInput: Array<String>) {

    var success: Boolean = successInput
    var languages: Array<String> = languageInput

    fun isSuccess(): Boolean {
        return success
    }

    @JvmName("getLanguages1")
    fun getLanguages(): Array<String> {
        return languages
    }

}