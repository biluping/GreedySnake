import kotlinx.serialization.Serializable
import java.util.*

@Serializable
class Phone(var name: String = UUID.randomUUID().toString(), var price: Int = 1)