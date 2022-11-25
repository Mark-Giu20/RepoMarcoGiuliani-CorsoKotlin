fun main() {

    println("For Loop")
    for (i in 0..10 step 1){
        println("Counter $i")
    }

    println("While Loop")
    var i = 0
    while (i<=10){
        println("Counter $i")
        i += 2
    }

    println("Do While Loop")
    i=0
    do {
        println("Counter $i")
        i += 2
    }while (i<=10)
}