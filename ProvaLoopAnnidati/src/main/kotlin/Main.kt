fun main() {
    for (userID in 1..2){
        print("$userID- Inserisci il tuo nome: ")
        val name = readLine()!!.toString()
        print(" Dove abiti: ")
        val livePlace = readLine()!!.toString()
        var petName:String?=""
        print(" Inserisci il numero di animali: ")
        val petsCount= readLine()!!.toInt()
        for (perID in 1..petsCount){
            print("Inserisci quale animale hai: ")
            petName = petName + readLine()!!.toString()
        }

        println("=========Dati Utente===========")
        println("Nome: ${name}")
        println("Abita in: ${livePlace}")
        println("Nomi degli animali: ${petName}")

        if (petName!!.contains("gatto")){
            println("Abbiamo programmi per il tuo gatto")
        }
    }
}