fun main() {
    println("\r\n")
    // val endereco:String = null
    val cep:String = "98u7"
    cep.uppercase()

    val endereco:String? = null
    println(endereco?.uppercase())

//    println(endereco!!.uppercase())

    var peso:Double? = null
    println(peso?.toInt())

    println("O dobro do peso: ${peso!! * 2}")

    if (peso != null) {
        println("O dobro do peso: ${peso * 2}")
    }

     println(populacao(null)!!.toDouble())
}

fun populacao(pais:String?):Int? {
    return 1000
}







