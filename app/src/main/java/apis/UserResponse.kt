package apis

data class UserResponse(
    var users:List<User>,
    val total :Int,
    val skip:Int,
    var limit:Int
)


