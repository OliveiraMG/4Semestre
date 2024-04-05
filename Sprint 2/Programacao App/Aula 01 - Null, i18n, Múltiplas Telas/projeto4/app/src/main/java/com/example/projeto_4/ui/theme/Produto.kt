package com.example.projeto_4.ui.theme

import java.io.Serializable

data class Produto(
    var nome:String? = "",
    var preco:Double? = 0.0,
    var perecivel:Boolean? = false
): Serializable
