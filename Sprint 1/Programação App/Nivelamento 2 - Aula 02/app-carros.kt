package apps

import Boletim
import Carro
import Heroi

fun main() {
    // instanciando um objeto do tipo Carro
    val meuCarro = Carro()

    println(meuCarro.fabricante)
    println(meuCarro.fabricacao)

    meuCarro.fabricante = "Fiat"
    println(meuCarro.fabricante)


    val meuBoletim = Boletim("XYZ", 9.5, 8.5)
    println(meuBoletim.nota1)
    val boletimB = Boletim("BBB", 9.5) // nota2 = 0.0
    val boletimC = Boletim("CCC", nota2 = 8.0) // nota1 = 0.0
    val boletimD = Boletim("DDD") // ambas as notas = 0.0
    // val boletimE = Boletim() // não compila! Precisa da matrícula
    println(meuBoletim.matricula)
    // meuBoletim.matricula = "WWW"

    println(meuCarro)
    println(meuBoletim)

    val heroi1 = Heroi(
    "Superman", "Clark", mutableListOf("Voar", "super força"))

    val heroi2 = Heroi(
    "Superman", "Clark", mutableListOf("Voar", "super força"))

    println(heroi1)
    println(heroi1 == heroi2)
}



