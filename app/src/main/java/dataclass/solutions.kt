package dataclass

data class solutions(
    val imageURL: String,
    val providedBy: String,
    val problem:String,
    val description:String,
    val type:String,
    val supporters:ArrayList<String>,
    val upvoteCount: Long,
    val city: String
)
