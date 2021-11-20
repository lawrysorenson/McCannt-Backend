package responses

import model.UserStats

class StatQueryResponse(success: Boolean, var stats: UserStats?): Response(success)