
class Utente(id : Int, nomeUser : String, passUser : String) {

    var id : Int = id
    var nomeUser : String = nomeUser
    var passUser : String = passUser
    var oggettiAcq : ArrayList<String> = ArrayList()
    fun stampaMenu(){
        println("Scrivi Pubblica per pubblicare un annuncio")
        println("Scrivi Commenta per commentare un annuncio")
        println("Scrivi Compra per comprare un oggetto")
        println("Scrivi Esci per eseguire il logout")
    }

    fun riepilogoacquisti(){
        if (oggettiAcq.size == 0){
            println("In questa sessione non hai acquistato nessun prodotto")
        } else {
            println("In questa sessione hai comprato i seguenti annunci:")
            for (i in 0 until oggettiAcq.size){
                println(oggettiAcq[i])
            }
        }
    }
    override fun toString(): String {
        var str : String = "ID utente: $id --> Nome utente: $nomeUser"
        return str
    }
}