fun main() {
    println("é nóis no kotlin!")
    println("aí sim, mano!")

    // Tipagem Dinâmica
    // a linguagem INFERIU o tipo a partir do valor
    var cidade = "São Paulo"
    var populacao = 10_000_000


    // Tipagem Estática
    var clube:String =  "Palmeiras"
    var torcedores:Int =  3_000_000
    var patrimonio:Double =  35_000_000.55
    var temMundial:Boolean =  false

    // var -> cria uma variável mutável, ou seja, pode ser reatribuída
    cidade = "Rio de Janeiro"

    // val -> Variáveis Imutáveis, ou seja, não pode ser reatribuída (equivalente ao const do JS ou final do Java)
    val cpf = "12345678900"
    val saborPizza = "Calabresa"

    // a linha abaixo bão compila
    // cpf = "98765432100"

    println("Em $cidade moram $populacao habitantes")
    println("Em ${cidade.uppercase()} moram ${populacao*2} pessoas")

    val idadeStr = "33"
    val pesoStr = "80.5"

    // String já tem métodos de conversão embarcados
    val idade:Int = idadeStr.toInt()
    val peso:Double = pesoStr.toDouble()
    println("Dobro da idade: ${idadeStr.toInt()*2}")
    
}