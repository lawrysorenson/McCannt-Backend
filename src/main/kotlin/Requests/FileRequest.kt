package Requests

class FileRequest(languageInput: String) {
    val language = languageInput

    @JvmName("getLanguage1")
    fun getLanguage(): String{
        return language
    }
}