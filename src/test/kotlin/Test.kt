import kotlinx.serialization.json.Json

fun main() {

//    var phone = Phone("myphone", 1000)
//    var json = Json.encodeToString(phone)
//    println(json)


    val json = """ [{"name":"myboy"}] """
    val person = Json.decodeFromString<List<Phone>>(json)
    println(person)

}