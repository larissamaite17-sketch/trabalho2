```jsp
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="model.Instrumento"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Instrumentos Cadastrados - Musical Store</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f2f2f2;
            margin: 0;
            padding: 30px;
        }

        .container {
            max-width: 1000px;
            margin: auto;
            background: white;
            padding: 25px;
            border-radius: 10px;
        }

        h1 {
            color: #183153;
            text-align: center;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 25px;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 12px;
            text-align: center;
        }

        th {
            background: #183153;
            color: white;
        }

        tr:nth-child(even) {
            background: #f5f5f5;
        }

        .botao {
            display: inline-block;
            padding: 10px 15px;
            background: #183153;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            margin-top: 20px;
        }

        .editar {
            background: #237547;
            color: white;
            padding: 7px 10px;
            text-decoration: none;
            border-radius: 4px;
            display: inline-block;
            margin: 2px;
        }

        .excluir {
            background: #a83232;
            color: white;
            padding: 7px 10px;
            text-decoration: none;
            border-radius: 4px;
            display: inline-block;
            margin: 2px;
        }

        .vazio {
            text-align: center;
            padding: 20px;
        }
    </style>
</head>

<body>

<div class="container">

    <h1>Instrumentos Cadastrados</h1>

    <table>
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Marca</th>
            <th>Categoria</th>
            <th>Preço</th>
            <th>Quantidade</th>
            <th>Ações</th>
        </tr>

        <%
            List<Instrumento> instrumentos =
                (List<Instrumento>) request.getAttribute("instrumentos");

            if (instrumentos != null && !instrumentos.isEmpty()) {
                for (Instrumento i : instrumentos) {
        %>

        <tr>
            <td><%= i.getId() %></td>
            <td><%= i.getNome() %></td>
            <td><%= i.getMarca() %></td>
            <td><%= i.getCategoria() %></td>
            <td>R$ <%= String.format("%.2f", i.getPreco()) %></td>
            <td><%= i.getQuantidade() %></td>

            <td>
                <a class="editar"
                   href="editar?id=<%= i.getId() %>">
                    Editar
                </a>

                <a class="excluir"
                   href="excluir?id=<%= i.getId() %>"
                   onclick="return confirm('Deseja realmente excluir este instrumento?');">
                    Excluir
                </a>
            </td>
        </tr>

        <%
                }
            } else {
        %>

        <tr>
            <td colspan="7" class="vazio">
                Nenhum instrumento cadastrado.
            </td>
        </tr>

        <%
            }
        %>

    </table>

    <a class="botao" href="formulario.jsp">
        Cadastrar instrumento
    </a>

    <a class="botao" href="index.html">
        Voltar ao início
    </a>

</div>

</body>
</html>
