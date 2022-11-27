fun main() {

    fun controlloStrVuota(str: String): Boolean {
        if (str == ""){
            return false
        }
        return true
    }
    var scelta : String= ""
    val quiz : Domande = Domande()

    do {
        println("Sei un utente o un admin (per terminare scrivi chiudi)")
        scelta = readLine()!!.toString()
        when(scelta){
            "utente" ->{
                if (quiz.qtaDomande() == 0){
                    println("Il quiz non è ancora pronto, chiedere ad un admin")
                } else {
                    var nome : String = ""
                    var cogn : String = ""
                    var controllo : Boolean = false
                    do {
                        print("Inserisci il tuo nome: ")
                        nome = readLine()!!.toString()
                        controllo = controlloStrVuota(nome)
                        if (!controllo){
                            println("Non può essere lasciato vuoto")
                        }
                    }while (!controllo)

                    do {
                        print("Inserisci il tuo cognome: ")
                        cogn = readLine()!!.toString()
                        controllo = controlloStrVuota(cogn)
                        if (!controllo){
                            println("Non può essere lasciato vuoto")
                        }
                    }while (!controllo)
                    val user : Utente = Utente(nome, cogn)
                    println("Benvenuto ${user.nomuUtente} ${user.cognomeUtente}")
                    println("Dovrai rispondere a ${quiz.qtaDomande()}\nper ogni domanda giusta guadagnerai 2 punti")

                    for (i in 0 until quiz.qtaDomande()){
                        var risposta : String = ""
                        quiz.stampaDomanda(i)
                        risposta = readLine()!!.toString()
                        if (quiz.verificaRisposta(i, risposta) == 1){
                            user.addPunti()
                        }
                    }
                    println("Quiz finito, hai totalizzato ${user.punti}")
                }
            }

            "admin" ->{
                print("Inserisci user admin: ")
                var user = readLine()!!.toString()
                print("Inserisci password: ")
                var pass = readLine()!!.toString()
                if (user == "admin" && pass == "admin"){
                    var adminScelta : String = ""
                    var chiudi : Boolean = false
                    println("Pannello di controllo admin")
                    do {
                        println("Scrivi Aggiungi per aggiungere una domanda")
                        println("Srcivi Modifica per modificare una domanda")
                        println("Scrivi Rimuovi per rimuovere una domanda")
                        println("Scrivi Stampa per stampare le domande")
                        println("Scrivi Esci per uscire")
                        adminScelta = readLine()!!.toString().lowercase()
                        when(adminScelta){
                            "aggiungi" ->{
                                var domanda : String
                                var risposta : String
                                var controllo : Boolean
                                do {
                                    println("Inserisci la domanda: ")
                                    domanda = readLine()!!.toString()
                                    controllo = controlloStrVuota(domanda)
                                    if (!controllo){
                                        println("Non può essere lasciato vuoto")
                                    }
                                }while (!controllo)
                                do {
                                    println("Inserisci la risposta: ")
                                    risposta = readLine()!!.toString()
                                    controllo = controlloStrVuota(risposta)
                                    if (!controllo){
                                        println("Non può essere lasciato vuoto")
                                    }
                                }while (!controllo)
                                quiz.addDomanda(domanda, risposta)
                                println("Domanda aggiunta")
                            }
                            "modifica" ->{
                                var sceltaMod : Int = -1
                                quiz.visualizza_Domande()
                                print("Inserisci un numero tra 1 e ${quiz.qtaDomande()} per modificare una domanda: ")
                                sceltaMod = readLine()!!.toInt()-1
                                if (sceltaMod >= 0 && sceltaMod <= quiz.qtaDomande()-1){
                                    var domanda : String
                                    var risposta : String
                                    var controllo : Boolean
                                    do {
                                        println("Inserisci la domanda: ")
                                        domanda = readLine()!!.toString()
                                        controllo = controlloStrVuota(domanda)
                                        if (!controllo){
                                            println("Non può essere lasciato vuoto")
                                        }
                                    }while (!controllo)
                                    do {
                                        println("Inserisci la risposta: ")
                                        risposta = readLine()!!.toString()
                                        controllo = controlloStrVuota(risposta)
                                        if (!controllo){
                                            println("Non può essere lasciato vuoto")
                                        }
                                    }while (!controllo)
                                    quiz.modDomanda(sceltaMod, domanda, risposta)
                                    println("Domanda modificata")
                                } else {
                                    println("Non è stata inserita nessuna domanda disponibile")
                                }
                            }
                            "rimuovi" ->{
                                var sceltaDel : Int = -1
                                quiz.visualizza_Domande()
                                print("Inserisci un numero tra 1 e ${quiz.qtaDomande()} per rimuovere una domanda: ")
                                sceltaDel = readLine()!!.toInt()-1
                                if (sceltaDel >= 0 && sceltaDel <= quiz.qtaDomande()-1){
                                    quiz.removeDomanda(sceltaDel)
                                    println("Domanda eliminata")
                                } else {
                                    println("Non è stata inserita nessuna domanda disponibile")
                                }
                            }
                            "stampa" ->{
                                quiz.visualizza_Domande()
                            }
                            "esci" ->{
                                println("Logout")
                                chiudi = true
                            }
                            else ->{
                                println("Errore: Non è stata selezionata nessuna scelta possibile")
                            }
                        }
                    }while (!chiudi)
                }
            }

            "esci" ->{
                println("Arrivederci")
            }
            else ->{
                println("Errore: Non è stata selezionata nessuna opzione disponibile")
            }
        }
    }while(scelta != "esci")
}
