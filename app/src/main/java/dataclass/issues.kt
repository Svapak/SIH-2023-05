package dataclass

data class issues(
    val imageURL:String,
    val description:String,
    val estimatedloss:String,
    val title: String,
    val locationLat: Long,
    val locationLong: Long,
    val city: String,
    val username: String,
    val type: String
)
