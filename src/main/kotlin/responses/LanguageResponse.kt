package responses

import model.Language

class LanguageResponse(success: Boolean, var languages: MutableList<Language>?): Response(success)