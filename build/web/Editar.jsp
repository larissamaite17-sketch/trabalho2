```jsp
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Instrumento"%>

<%
    Instrumento i = (Instrumento) request.getAttribute("instrumento");

    if (i == null) {
        response.sendRedirect("listar");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Instrumento - Musical Store</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f2f2f2;
            margin: 0;
            padding: 30px;
        }

        .container {
            max-width: 550px;
            margin: auto;
            background: white;
            padding: 25px;
            border-radius: 10px;
        }

        h1 {
            color: #183153;
            text-align: center;
        }

        label {
            display: block;
            margin-top: 15px;
        }

        input {
            box-sizing: border-box;
            width: 100%;
            padding: 10px;
            margin-top: 5px;
        }

        button, .voltar {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 15px;
            border: none;
            border-radius: 5px;
            background: #183153;
            color: white;
            text-decoration: none;
            cursor: pointer;
        }
    </style>
</head>

<body>

<div class="container">
    <h1>Editar Instrumento</h1>

    <form action="editar" method="post">

        <input type="hidden" name="id" value="<%= i.getId() %>">

        <label>Nome:</label>
        <input type="text" name="nome"
               value="<%= i.getNome() %>" required>

        <label>Marca:</label>
        <input type="text" name="marca"
               value="<%= i.getMarca() %>" required>

        <label>Categoria:</label>
        <input type="text" name="categoria"
               value="<%= i.getCategoria() %>" required>

        <label>Preço:</label>
        <input type="number" name="preco" step="0.01" min="0"
               value="<%= i.getPreco() %>" required>

        <label>Quantidade:</label>
        <input type="number" name="quantidade" min="0"
               value="<%= i.getQuantidade() %>" required>

        <button type="submit">Salvar alterações</button>

        <a class="voltar" href="listar">Cancelar</a>
    </form>
</div>

</body>
</html>
```