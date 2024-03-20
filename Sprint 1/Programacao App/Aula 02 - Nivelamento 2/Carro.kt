import java.time.LocalDateTime

class Carro {
    var fabricante:String = ""
    var combustivel:Double = 0.0
    var dono:String = "(sem dono)"
    val fabricacao = LocalDateTime.now()
}