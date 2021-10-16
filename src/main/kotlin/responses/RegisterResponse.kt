package responses

import model.AuthToken

class RegisterResponse(success: Boolean, var authToken: AuthToken?) : Response(success)