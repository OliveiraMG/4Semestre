// dentro de alguma função @Composable:

	val filme = filmeViewModel.filmeAtual.observeAsState().value!!
    val lista = filmeViewModel.filmes.observeAsState().value!!

    var erroApi = filmeViewModel.erroApi.observeAsState().value!!

    val focusRequester = remember { FocusRequester() }

    Column {
        Text("Cadastro de FILMES")
        if (erroApi.isNotBlank()) {
            Text(erroApi, style = TextStyle(fontSize = 35.sp, color = Color.Red))
        }
        if (filme.id != null) {
            Text("Id: ${filme.id}", style = TextStyle(fontSize = 30.sp, color = Color.Blue))
        }
        TextField(
            label = { Text("Nome") },
            value = filme.nome ?: "",
            onValueChange = {
                filmeViewModel.setFilmeAtual(filme.copy(nome = it))
            },
            // o modifier abaixo indica que este campo comecará com o foco na tela
            modifier = Modifier.focusRequester(focusRequester),
        )
        TextField(
            label = { Text("Salário") },
            value = filme.custoProducao?.toString() ?: "",
            onValueChange = {
                filmeViewModel.setFilmeAtual(filme.copy(custoProducao = it.toDoubleOrNull()))
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Row {
            Button(onClick = {
                filmeViewModel.salvarFilme()
            }) {
                Text(if (filme.id == null) "Adicionar" else "Atualizar")
            }

            if (filme.id != null) {
                Button(onClick = {
                    filmeViewModel.filmeAtual.value = Filme()
                }) {
                    Text("Novo")
                }
            }
        }
        LazyColumn(modifier = Modifier.weight(1f)){
            items(items = lista.toList()) {
                Row {
                    Text("Nome: ${it.nome} - Custo: ${it.custoProducao}")
                    TextButton(
                        onClick = { filmeViewModel.removerFilme(it) }) {
                        Text("[X] Excluir")
                    }
                    TextButton(
                        onClick = { filmeViewModel.setFilmeAtual(it) }) {
                        Text("[@] Editar")
                    }
                }
            }
        }
    }

    // Este componente efetua a colocação do foco no componente que desejamos
    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    } 
