package responses

import model.AuthToken

class LoginResponse(var success: Boolean, var authToken: AuthToken?)