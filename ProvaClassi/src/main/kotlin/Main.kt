import java.util.ArrayList
import kotlin.random.Random

fun main() {

    var arCani : ArrayList<Cane> = ArrayList()
    print("Quanti cani vuoi inserire: ")
    val nCani : Int = readLine()!!.toInt()
    for (i in 0 until nCani){
        print("Inserisci il nome del cane ${i+1}: ")
        var nome : String= readLine().toString()
        print("Il cane ${i+1} è vaccinato? ")
        var vaccini : Boolean = false
        do {
            var risp : String = readLine()!!.toString()
            var esci : Boolean = false
            if (risp == "Si" || risp == "y"){
                vaccini = true
                esci = true
            } else if (risp == "No" || risp == "n"){
                vaccini = false
                esci = true
            } else {
                print("Errore, reinserire la risposta: ")
            }
        }while (!esci)

        print("Inserisci l'età del cane: ")
        var eta : Int = readLine()!!.toInt()
        arCani.add(Cane(nome, vaccini, eta))
    }

    for (i in 0 until arCani.size) {
        if (arCani.get(i).vaccini) {
            println("Cane ${i + 1}: Nome -> ${arCani.get(i).nome}, Vaccinato, Età -> ${arCani.get(i).anni}")
        } else {
            println("Cane ${i + 1}: Nome -> ${arCani.get(i).nome}, Non vaccinato, Età -> ${arCani.get(i).anni}")
        }
        arCani.get(i).Abbaiare()
        arCani.get(i).Correre(Random.nextInt(1, 40))
        println()
    }
}