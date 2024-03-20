fun main() {
    // listOf -> cria uma lista imutável SOMENTE DE LEITURA, não podemos adicionar, remover, mudar posição e etc
    val frutas = listOf("Maçã", "Banana", "Pera", "Uva", "Melancia")

    println(frutas[2])
    println("Primeira: ${frutas.first()}")
    println("Última: ${frutas.last()}")
    println("Quantas frutas: ${frutas.size}")

    // frutas.add("Abacaxi") // não compila

    // mutableListOf -> cria uma lista mutável DE LEITURA e ESCRITA, ou seja, podemos adicionar, remover, mudar posição e etc
    val paises = mutableListOf("Brasil", "Argentina", "Uruguai", "Chile")
    paises.add("Paraguai")
    paises.remove("Argentina")
    paises.removeAt(0)
    println(paises)


    // Iterando numa lista
    // Usando o nome automático "it" para cada elemento
    frutas.forEach {
        println(it)
    }

    // Usando o nome explícito "fruta" para cada elemento
    frutas.forEach { fruta ->
        println(fruta)
    }

    // Iteração com o índice
    // nesse caso é obrigatório dar nome as variáveis de indice e elemento (i, fruta)
    frutas.forEachIndexed { i, fruta ->
        println("fruta $i - $fruta")
    }



    // Filtrando listas
    val filtro1 = frutas.filter { it.contains("e") }
    println(filtro1)

    val filtro2 = paises.filter { it.length >= 6 }
    println(filtro2)

    val contagem1 = frutas.count { it.contains("e") }
    println(contagem1)


    // sort() -> ordena usando a ordem natural dos elementos
    // ex: String -> ordem alfabética
    // ex: Int -> ordem crescente
    paises.sort()
    println(paises)


    val listaLoka = mutableListOf(22, 1, 9, 7, 15)
    listaLoka.sort()
    println(listaLoka)



}