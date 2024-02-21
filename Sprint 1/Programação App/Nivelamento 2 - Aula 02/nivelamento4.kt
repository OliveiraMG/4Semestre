import kotlin.math.pow

fun main() {
    println("potência: ${potencia(2.0, 3.0)}")
    println("potência: ${potencia(2.0)}")
    println("potência: ${potencia(3.0, 2.0)}")
println("potência: ${potencia(potencia = 3.0, base = 2.0)}")
}

fun potencia(base:Double, potencia:Double = 3.0): Double {
    return base.pow(potencia)
}