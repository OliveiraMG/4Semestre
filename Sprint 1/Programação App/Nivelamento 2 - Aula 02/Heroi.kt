/*
uma data class:
- possui um toString() embarcado
- se comparar 2 instâncias com os mesmos valores, será true
  (cria um equals() e hashCode() usando todos os atributos)
 */
data class Heroi(
    val nomeHeroi: String,
    val nomeReal: String,
    val poderes: MutableList<String>
)