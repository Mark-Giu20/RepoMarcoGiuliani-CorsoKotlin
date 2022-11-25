fun main() {
    println("Calcolatrice")
    print("Primo numero: ")
    val number1 = readLine()!!.toDouble()
    print("Secondo numero: ")
    val number2 = readLine()!!.toDouble()

    val sum = number1 + number2
    println("Somma: $sum")

    val sub = number1 - number2
    println("Sottrazione: $sub")

    val mul = number1 * number2
    println("Moltiplicazione: $mul")

    val div = number1 / number2
    println("Divisione: $div")
}