fun main() {
    // os if, if-else no kotlin são EXATAMENTE como
    // no Java e JavaScript

    var idade = 15

    val resultado = if (idade >= 15) "pode namorar" else "vai brincar"
    println(resultado)

    idade = 350
    /*
    when para execução de instruções
     */
    when (idade) {
        in 0..1 -> println("bebê")
        2 -> println("criancinha")
        10 -> {
            println("pré-adolescente")
            println("vai se preparando")
            println("muitas espinhas")
        }
        in 19..89 -> println("adulto")
        90 -> println("idoso")
        else -> println("idade inválida")
    }

    val gols = 3
    val tipo = when (gols) {
        0 -> "péssimo"
        in 1..2 -> "meia boca"
        in 3..5 -> "bom"
        in 6..Int.MAX_VALUE -> "ótimo"
        else -> "valor inválido!"
    }
    println(tipo)

}

