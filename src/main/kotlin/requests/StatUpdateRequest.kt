package requests

import model.UserStat

class StatUpdateRequest(var newStats: ArrayList<UserStat>, var updatedStats: ArrayList<UserStat>)