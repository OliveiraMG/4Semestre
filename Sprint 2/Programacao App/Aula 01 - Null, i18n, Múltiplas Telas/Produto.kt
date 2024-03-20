package com.example.projeto04

import java.io.Serializable

data class Produto(
    var nome: String = "",
    var preco: Double? = null,
    var perecivel:Boolean = false
) : Serializable
/*
: Serializable -> equivale ao "implements Serializable" do Java
Isso é OBRIGATÓRIO se o objetivo da classe for
trafegar dados entre telas
 */

