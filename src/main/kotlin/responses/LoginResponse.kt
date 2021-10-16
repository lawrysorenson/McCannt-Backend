package responses

import model.AuthToken

class LoginResponse(success: Boolean, var authToken: AuthToken?) : Response(success)