package dataclass

data class problems(
    val imageURL:String,
    val description:String,
    val estimatedloss:String,
    val title: String,
    val type: String,
    val city: String,
    val locationLat: Long,
    val locationLong: Long
)
