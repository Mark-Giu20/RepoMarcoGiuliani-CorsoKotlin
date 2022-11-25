import java.util.ArrayList

fun main() {
    println("App Animali")
    val listOfPets:ArrayList<String> = ArrayList()
    while (true){
        println("Inserisci l'animale o scrivi esci per terminare l'isnerimento")
        var ins : String = readLine()!!.toString()
        if (ins == "esci" || ins == "Esci"){
            break
        }
        listOfPets.add(ins)
    }
    println("I tuoi animali sono:")
    for (i in 0 until listOfPets.size){
        println("Animale ${i+1}:  ${listOfPets[i]}")
    }
    print("Inserisci il nome dell'animale da rimuovere: ")
    val indexRemove = readLine()!!.toString()
    var boolRim : Boolean = false
    for (i in 0 until listOfPets.size){
        if (indexRemove.equals(listOfPets[i])){
            listOfPets.removeAt(i)
            boolRim = true
        }
    }
    if(boolRim){
        println("rimosso")
    } else{
        println("Errore")
    }
    println("I tuoi animali sono:")
    for (i in 0 until listOfPets.size){
        println("Animale ${i+1}:  ${listOfPets[i]}")
    }
    print("Inserisci il numero dell'animale da modificare: ")
    var indexSet = readLine()!!.toInt()-1
    if (indexSet < listOfPets.size && indexSet >= 0){
        print("Inserire l'animale: ")
        listOfPets.set(indexSet, readLine()!!.toString())
        println("Modificato")
    }else{
        println("Errore")
    }
    println("I tuoi animali sono:")
    for (i in 0 until listOfPets.size){
        println("Animale ${i+1}:  ${listOfPets[i]}")
    }
    listOfPets.clear()
    println("Lista pulita: ${listOfPets.toString()}")
}