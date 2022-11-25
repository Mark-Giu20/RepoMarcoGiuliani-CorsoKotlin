class Admin {
    private val nomeAdmin : String = "admin"
    private val passAdmin : String = "admin"

    fun stampaMenu(){
        println("Scrivi Utenti per visualizzare gli utenti registrati")
        println("Scrivi Modifica per modificare un annuncio")
        println("Scrivi Elimina per eliminare un annuncio")
        println("Scrivi Banna per bannare un utente")
        println("Scrivi esci per eseguire il logout")
    }

    public fun controlloAdmin(user : String, password : String) : Boolean{
        if (nomeAdmin == user && passAdmin == password) return true
        return false
    }
}