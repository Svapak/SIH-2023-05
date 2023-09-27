package dataclass

data class solutions(
    //val imageURL: String,
    val providedBy: String="",
    val problem:String="",
    val description:String="",
    val type:String="",
    val supporters: ArrayList<String> = arrayListOf<String>(),
    val upvoteCount: Long=0,
    val city: String=""
)
