fun main() {

}

// função sem parâmetros e sem retorno
fun cumprimentar() {
    println("Olá, mundo!")
}

// função com 1 parâmetro e sem retorno
fun bomDia(quem:String) {
    println("Bom dia, $quem!")
}

// função com 2 parâmetros e sem retorno
fun boaTarde(quem:String, temperatura:Double) {
    println("Boa tarde, $quem! Hoje está $temperatura graus")
}

// função com 1 parâmetro e com retorno
fun boaNoite(quem:String):String {
    println("Executando a função boaNoite")
    return "Boa noite, $quem!"
}

