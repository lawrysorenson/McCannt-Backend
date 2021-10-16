package responses

import model.UserStat

class StatQueryResponse(success: Boolean, var stats: ArrayList<UserStat>?): Response(success)