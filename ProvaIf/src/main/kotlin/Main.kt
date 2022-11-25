fun main() {
    println("Inserisci il tuo voto: ")
    var voto =  readLine()!!.toInt()
    print("Il tuo voto è ")
    if(voto in 90..99){
        if (voto > 95){
            println("A+")
        }else{
            println("A-")
        }
    }else if(voto in 80..89){
        if (voto > 85){
            println("B+")
        }else{
            println("B-")
        }
    }else if(voto in 70..79){
        if (voto > 75){
            println("C+")
        }else{
            println("C-")
        }
    }else if(voto in 60..69){
        if (voto > 65){
            println("D+")
        }else{
            println("D-")
        }
    }else{
        println("FS" + " (Anche detto fai schifo)")
    }

    //commento

    /*Commento
    * multilinea*/

    println("Fine")
}