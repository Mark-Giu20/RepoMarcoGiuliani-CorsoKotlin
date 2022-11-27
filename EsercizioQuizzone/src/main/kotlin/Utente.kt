class Utente (nomeU : String, cognU : String){
    val nomuUtente = nomeU
    val cognomeUtente = cognU
    var punti = 0

    fun addPunti(){
        punti = punti + 2
    }

    fun returnPunti() : Int{
        return punti
    }
}