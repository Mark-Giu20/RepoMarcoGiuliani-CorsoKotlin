class Annuncio (nome : String, nomeProdotto : String, prezzo : Double){
    var nomeUser : String = nome
    var prodotto : String = nomeProdotto
    var prezzo : Double = prezzo
    var commenti : ArrayList<String> = ArrayList()
    var idUserCom : ArrayList<Int> = ArrayList()

    fun aggiungiCommento (commento : String, idUser: Int){
        commenti.add(commento)
        idUserCom.add(idUser)
    }

    fun rimuoviCommento (idUser: Int){
        for (i in 0 until commenti.size){
            if (idUserCom[i] == idUser){
                commenti.removeAt(i)
                idUserCom.removeAt(i)
            }
        }
    }

    fun modificaProdotto (newProdotto : String, newPrezzo : Double){
        prodotto = newProdotto
        prezzo = newPrezzo
    }

    override fun toString(): String {
        var str : String = "Utente che ha pubblicato l'annuncio: ${nomeUser}\nProdotto: $prodotto\nPrezzo: $prezzo\n"
        if(commenti.size == 0){
            str += "Non ci sono commenti\n"
        } else {
            str += "Commenti:\n"
            for (i in 0 until commenti.size){
                str += "${commenti[i]}\n"
            }
        }
        return str

    }
}