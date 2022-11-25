class Cane (var nome : String, var vaccini : Boolean, var anni : Int) {

    fun Abbaiare(){
        println("Bau!")
    }
    fun Correre(velocita : Int){
        println("Il cane corre a $velocita metri all'ora")
        if (velocita in 20..30){
            println("Che cane veloce!")
        } else if (velocita in 31..40){
            println("Possiedi un cane da record")
        }
    }

}