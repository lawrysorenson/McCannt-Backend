package Requests

class RegisterRequest(var username: String, var password: String,
                      var firstName: String?, var lastName: String?,
                      var nativeLanguage: String, var learningLanguage: String)