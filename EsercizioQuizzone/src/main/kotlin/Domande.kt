import java.util.ArrayList

class Domande{
    private val domande : ArrayList<String>
    private val risposte : ArrayList<String>

    init {
        domande = ArrayList<String>()
        risposte = ArrayList<String>()
    }

    fun visualizza_Domande(){
        if (domande.isEmpty()){
            println("Non ci sono domande disponibili")
        } else {
            println("Queste sono le domande del quiz:")
            for (i in 0 until domande.size){
                println("Domanda ${i+1}: ${domande[i]}")
                println("Risposta ${risposte[i]}")
            }
        }
    }

    fun addDomanda(domanda : String, risposta : String){
        domande.add(domanda)
        risposte.add(risposta)
    }

    fun removeDomanda(index: Int){
        domande.removeAt(index)
        risposte.removeAt(index)
    }

    fun modDomanda (index : Int, domanda : String, risposta : String) {
        domande.set(index, domanda)
        risposte.set(index, risposta)
    }

    fun stampaDomanda(index : Int){
        println("Domanda ${index+1}) ${domande[index]}")
    }

    fun verificaRisposta(index: Int, ris: String) : Int{
        if (risposte[index].lowercase() == ris.lowercase()){
            return 1
        }
        return 0
    }

    fun qtaDomande() : Int{
        return domande.size
    }

}