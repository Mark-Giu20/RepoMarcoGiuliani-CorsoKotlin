import java.util.ArrayList

fun controlloStrVuota(str: String): Boolean {
    if (str == ""){
        return false
    }
    return true
}

fun utenteGiaPres(ar : ArrayList<Utente>, user : Utente):Boolean{
    for (i in 0 until ar.size){
        if (ar.get(i).nomeUser == user.nomeUser){
            return true
        }
    }
    return false
}

fun login (ar : ArrayList<Utente>, nome : String, pass : String, ban : ArrayList<Int>) : Int{
    var foundUser : Int = -1
    for (i in 0 until ar.size){
        if(nome.lowercase() == ar[i].nomeUser.lowercase() && pass == ar[i].passUser){
            foundUser = i
        }
    }
    if (foundUser != -1){
        for (i in 0 until ban.size){
            if (ar[foundUser].id == ban[i]) {
                foundUser = -2
            }
        }
    }
    return foundUser
}

fun main() {
    val Utenti :ArrayList<Utente> = ArrayList()
    val Bacheca : ArrayList<Annuncio> = ArrayList()
    val userBannati : ArrayList<Int> = ArrayList()
    var numUtenti : Int = 1000
    var admin : Admin = Admin()
    var termina : Boolean = false
    var sceltaUtente : String = ""
    do {
        println("Scrivi Registrati per registrarti nel sistema")
        println("Scrivi Accedi per accedere al sistema")
        println("Scrivi Admin per accedere al pannello di controllo dell'admin")
        println("Scrivi Chiudi per terminare il programma")
        sceltaUtente = readLine()!!.toString().lowercase()
        when(sceltaUtente){
            "registrati" ->{
                var nome : String = ""
                var password : String = ""
                var controllo : Boolean = false
                print("Inserisci il nome: ")
                do {
                    nome = readLine()!!.toString()
                    controllo = controlloStrVuota(nome)
                    if (!controllo){
                        println("Non può essere lasciato vuoto, reinserire il nome")
                    }
                }while (!controllo)
                print("Inserire la password: ")
                do {
                    password = readLine()!!.toString()
                    controllo = controlloStrVuota(password)
                    if (!controllo){
                        println("Non può essere lasciato vuoto, reinserire la password")
                    }
                }while (!controllo)
                var user : Utente = Utente(numUtenti, nome, password)
                if (utenteGiaPres(Utenti, user)){
                    println("Utente già registrato, prova ad eseguire il login")
                } else {
                    Utenti.add(user)
                    numUtenti++
                    println("Registrazione avvenuta")
                }
            }
            "accedi" ->{
                var nome : String = ""
                var password : String = ""
                var controllo : Boolean = false
                print("Inserisci il nome: ")
                do {
                    nome = readLine()!!.toString()
                    controllo = controlloStrVuota(nome)
                    if (!controllo){
                        println("Non può essere lasciato vuoto, reinserire il nome")
                    }
                }while (!controllo)
                print("Inserire la password: ")
                do {
                    password = readLine()!!.toString()
                    controllo = controlloStrVuota(password)
                    if (!controllo){
                        println("Non può essere lasciato vuoto, reinserire la password")
                    }
                }while (!controllo)
                var idUtente : Int = login(Utenti, nome, password, userBannati)
                if (idUtente == -1){
                    println("L'utente non è registrato")
                } else if (idUtente == -2){
                    println("L'utente di nome $nome è stato bannato da un admin")
                } else {
                    var u : Utente = Utenti[idUtente]
                    println("Benvenuto ${u.nomeUser}")
                    var chiudi : Boolean = false
                    do {
                        u.stampaMenu()
                        sceltaUtente = readLine()!!.toString().lowercase()
                        when(sceltaUtente){
                            "pubblica" ->{
                                print("Inserisci il prodotto: ")
                                var prodotto : String = readLine()!!.toString()
                                print("Inserisci il prezzo del prodotto: ")
                                var prezzo : Double = readLine()!!.toDouble()
                                Bacheca.add(Annuncio(u.nomeUser, prodotto, prezzo))
                                println("Annuncio aggiunto")
                            }
                            "commenta" ->{
                                if (Bacheca.size == 0){
                                    println("Non ci sono annunci pubblicati sulla bacheca")
                                } else {
                                    println("Questi sono gli annunci presenti al momento:")
                                    for (i in 0 until Bacheca.size){
                                        println(Bacheca[i].toString())
                                    }
                                    var risp : String = ""
                                    var esci : Boolean = false
                                    do {
                                        print("Vuoi commentare un annuncio? ")
                                        risp = readLine().toString().lowercase()
                                        if (risp == "y" || risp == "si"){
                                            do{
                                                print("Inserisci il nome del prodotto da commentare: ")
                                                var prodScelto : String = readLine()!!.toString()
                                                var aggiunto : Boolean = false
                                                for (i in 0 until Bacheca.size){
                                                    if (Bacheca[i].prodotto == prodScelto){
                                                        println("Inserisci il commento")
                                                        var com : String = "${u.nomeUser}: "
                                                        com += readLine()!!.toString()
                                                        Bacheca[i].aggiungiCommento(com, u.id)
                                                        aggiunto = true
                                                        break;
                                                    }
                                                }
                                                if (aggiunto){
                                                    println("Commento aggiunto")
                                                    esci = true
                                                } else {
                                                    println("Errore: Non è stato selezionato nessun articolo disponibile")
                                                }
                                            }while (!aggiunto)
                                        } else if (risp == "n" || risp == "no") {
                                            println("Ok")
                                            esci = true
                                        } else {
                                            println("Errore: Non è stata selezionata nessuna scelta possibile")
                                        }
                                    }while (!esci)
                                }
                            }
                            "compra" -> {
                                if (Bacheca.size == 0) {
                                    println("Non ci sono annunci pubblicati sulla bacheca")
                                } else {
                                    println("Questi sono gli annunci presenti al momento:")
                                    for (i in 0 until Bacheca.size) {
                                        println(Bacheca[i].toString())
                                    }
                                    var risp: String = ""
                                    do {
                                        print("Vuoi comprare? ")
                                        risp = readLine().toString().lowercase()
                                        var esci: Boolean = false
                                        if (risp == "y" || risp == "si") {
                                            var risp: String = ""
                                            do {
                                                print("Inserisci il nome del prodotto da comprare: ")
                                                var prodScelto: String = readLine()!!.toString()
                                                var comprato: Boolean = false
                                                for (i in 0 until Bacheca.size) {
                                                    if (Bacheca[i].prodotto == prodScelto) {
                                                        u.oggettiAcq.add("Oggetto comprato: ${Bacheca[i].prodotto} al costo di ${Bacheca[i].prezzo}")
                                                        Bacheca.removeAt(i)
                                                        comprato = true
                                                        break;
                                                    }
                                                }
                                                if (comprato) {
                                                    println("Oggetto acquistato")
                                                    esci = true
                                                } else {
                                                    println("Errore: Non è stato selezionato nessun articolo disponibile")
                                                }
                                            } while (!comprato)
                                        } else if (risp == "n" || risp == "no") {
                                            println("Ok")
                                            esci = true
                                        } else {
                                            println("Errore: Non è stata selezionata nessuna scelta possibile")
                                        }
                                    } while (!esci)
                                }
                            }
                            "esci" ->{
                                chiudi = true
                                println("Logout")
                            }
                            else ->{
                                println("Errore: Non è stata selezionata nessuna scelta possibile")
                            }
                        }
                    }while (!chiudi)
                    u.riepilogoacquisti()
                }
            }
            "admin" ->{
                var nome : String = ""
                var password : String = ""
                var controllo : Boolean = false
                print("Inserisci il nome dell'admin: ")
                do {
                    nome = readLine()!!.toString()
                    controllo = controlloStrVuota(nome)
                    if (!controllo){
                        println("Non può essere lasciato vuoto, reinserire il nome")
                    }
                }while (!controllo)
                print("Inserire la password admin: ")
                do {
                    password = readLine()!!.toString()
                    controllo = controlloStrVuota(password)
                    if (!controllo){
                        println("Non può essere lasciato vuoto, reinserire la password")
                    }
                }while (!controllo)
                if(!(admin.controlloAdmin(nome, password))){
                    println("Non hai inserito le credenziali giuste")
                } else {
                    println("Pannello di controllo admin")
                    var chiudi : Boolean = false
                    do {
                        admin.stampaMenu()
                        sceltaUtente = readLine()!!.toString().lowercase()
                        when(sceltaUtente){
                            "utenti" ->{
                                if (Utenti.size == 0){
                                    println("Non ci sono utenti registrati")
                                } else {
                                    println("Questi sono gli utenti registrati")
                                    for (i in 0 until Utenti.size){
                                        println(Utenti[i].toString())
                                    }
                                }
                            }
                            "modifica" ->{
                                if (Bacheca.size == 0){
                                    println("Non ci sono annunci pubblicati")
                                } else {
                                    println("Questi sono gli annunci pubblicati")
                                    for (i in 0 until Bacheca.size){
                                        println(Bacheca[i].toString())
                                    }
                                    var risp: String = ""
                                    do {
                                        print("Vuoi modificare qualche annuncio? ")
                                        risp = readLine().toString().lowercase()
                                        var esci: Boolean = false
                                        if (risp == "y" || risp == "si") {
                                            do {
                                                print("Scegli quale prodotto modificare: ")
                                                var prodScelto: String = readLine()!!.toString()
                                                var modificato: Boolean = false
                                                for (i in 0 until Bacheca.size) {
                                                    if (Bacheca[i].prodotto == prodScelto) {
                                                        print("Inserisci il prodotto modificato: ")
                                                        var prodotto : String = readLine()!!.toString()
                                                        print("Inserisci il prezzo modificato: ")
                                                        var prezzo : Double = readLine()!!.toDouble()
                                                        Bacheca[i].modificaProdotto(prodotto, prezzo)
                                                        modificato = true
                                                        break
                                                    }
                                                }
                                                if (modificato) {
                                                    println("Prodotto modificato")
                                                    esci = true
                                                } else {
                                                    println("Errore: Non è stato selezionato nessun articolo disponibile")
                                                }
                                            } while (!modificato)
                                        } else if (risp == "n" || risp == "no") {
                                            println("Ok")
                                            esci = true
                                        } else {
                                            println("Errore: Non è stata selezionata nessuna scelta possibile")
                                        }
                                    } while (!esci)
                                }
                            }
                            "elimina" ->{
                                if (Bacheca.size == 0){

                                } else {
                                    println("Questi sono gli annunci pubblicati")
                                    for (i in 0 until Utenti.size){
                                        println(Bacheca[i].toString())
                                    }
                                    var risp: String = ""
                                    do {
                                        print("Vuoi eliminare qualche annuncio? ")
                                        risp = readLine().toString().lowercase()
                                        var esci: Boolean = false
                                        if (risp == "y" || risp == "si") {
                                            do {
                                                print("Scegli quale prodotto eliminare: ")
                                                var prodScelto: String = readLine()!!.toString()
                                                var elimina: Boolean = false
                                                for (i in 0 until Bacheca.size) {
                                                    if (Bacheca[i].prodotto == prodScelto) {
                                                        Bacheca.removeAt(i)
                                                        elimina = true
                                                        break
                                                    }
                                                }
                                                if (elimina) {
                                                    println("Annuncio eliminato")
                                                    esci = true
                                                } else {
                                                    println("Errore: Non è stato selezionato nessun articolo disponibile")
                                                }
                                            } while (!elimina)
                                        } else if (risp == "n" || risp == "no") {
                                            println("Ok")
                                            esci = true
                                        } else {
                                            println("Errore: Non è stata selezionata nessuna scelta possibile")
                                        }
                                    } while (!esci)
                                }
                            }

                            "banna" ->{
                                if (Utenti.size == 0){
                                    println("Non ci sono utenti registrati")
                                } else {
                                    println("Questi sono gli utenti registrati")
                                    for (i in 0 until Utenti.size){
                                        println(Utenti[i].toString())
                                    }
                                }
                                print("Inserisci il nome dell'utente da bannare ")
                                var usrBan : String = readLine()!!.toString()
                                var bannato : Boolean = false
                                for (i in 0 until Utenti.size){
                                    if (Utenti[i].nomeUser.lowercase() == usrBan.lowercase()){
                                        userBannati.add(Utenti[i].id)
                                        for (n in 0 until Bacheca.size){
                                            if (Bacheca[n].nomeUser.lowercase() == usrBan.lowercase()){
                                                Bacheca.removeAt(n)
                                            }else{
                                                Bacheca[n].rimuoviCommento(Utenti[i].id)
                                            }
                                        }
                                        bannato = true
                                        break
                                    }
                                }
                                if (bannato){
                                    println("Utente bannato")
                                } else {
                                    println("Utente da bannare non torvato")
                                }

                            }
                            "esci" ->{
                                chiudi = true
                                println("Logout")
                            }
                            else ->{
                                println("Errore: Non è stata selezionata nessuna scelta possibile")
                            }
                        }
                    }while (!chiudi)
                }

            }
            "chiudi" ->{
                termina = true
                println("Arrivederci")
            }
            else ->{
                println("Errore: Non è stata selezionata nessuna scelta possibile")
            }
        }
    }while (!termina)
}