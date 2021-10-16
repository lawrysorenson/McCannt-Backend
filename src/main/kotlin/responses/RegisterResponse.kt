package responses

import model.AuthToken

class RegisterResponse(var success: Boolean, var authToken: AuthToken?)