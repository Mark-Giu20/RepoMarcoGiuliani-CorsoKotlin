fun main() {
    print("Scegli cosa ordinare: ")
    val sceltaInt  = readLine()!!.toInt()
    when(sceltaInt){

        1 ->{
            println("Hai scelto ${sceltaInt}")
        }

        2 ->{
            println("Hai scelto ${sceltaInt}")
        }

        3 ->{
            println("Hai scelto ${sceltaInt}")
        }

        else ->{
            println("Hai scelto ${sceltaInt} caso comune")
        }
    }

    print("Scegli cosa ordinare: ")
    val sceltaStr  = readLine()!!.toString()
    when(sceltaStr) {

        "Pippo" -> {
            println("${sceltaStr}")
        }

        "One" -> {
            println("The One Piece")
        }

        "Si" -> {
            println("No")
        }

        else -> {
            println("${sceltaStr} caso comune")
        }
    }
}