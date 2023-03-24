<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Site da Babinha</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="conf.css">
        <link rel="stylesheet" href="menu.css">
    </head>
    <body>
        <header>
            <h1>Senac</h1>
            <p style=" margin-right: 10px">${m} ${mc}</p>
        </header>
        <nav>
            <p>
            <div class="topnav" id="myTopnav">
                <a href="#home" class="active">Home</a>
                <a href="#news">News</a>
                <a href="#contact">Contact</a>
                <div class="dropdown">
                    <button class="dropbtn">Departamento 
                        <i class="fa fa-caret-down"></i>
                    </button>
                    <div class="dropdown-content">
                        <a href="CadastroDepartamento.html" target="conteudo">Incluir</a>
                        <a href="AlterarDepartamento.html" target="conteudo">Alterar</a>
                        <a href="ExcluirDepartamento.html" target="conteudo">Excluir</a>
                        <a href="ConsultarDepartamento.html" target="conteudo">Consultar</a>
                        <a href="ListarDepartamento.html" target="conteudo">Listar</a>

                    </div>
                </div> 
                  <div class="dropdown">
                    <button class="dropbtn">Funcionário 
                        <i class="fa fa-caret-down"></i>
                    </button>
                    <div class="dropdown-content">
                        <a href="CadastroFuncionario.html" target="conteudo">Incluir</a>
                        <a href="AlterarFuncionario.html" target="conteudo">Alterar</a>
                        <a href="ExcluirFuncionario.html" target="conteudo">Excluir</a>
                        <a href="ConsultarFuncionario.html" target="conteudo">Consultar</a>
                        <a href="ListarFuncionario.html" target="conteudo">Listar</a>

                    </div>
                </div>

                    <a href="javascript:void(0);" style="font-size:15px;" class="icon" onclick="myFunction()">&#9776;</a>
            </div>
        </p>
    </nav>
    <main>
        <p>
            <iframe src="abertura.html" name="conteudo"></iframe>
        </p>
    </main>
    <footer>
        <p>
            FOOTER
        </p>
    </footer>

</body>