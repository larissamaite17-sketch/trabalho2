
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cadastrar Instrumento</title>
</head>
<body>
    <h1>Cadastrar Instrumento Musical</h1>

    <form action="cadastrar" method="post">
        <label>Nome:</label>
        <input type="text" name="nome" required>
        <br><br>

        <label>Marca:</label>
        <input type="text" name="marca" required>
        <br><br>

        <label>Categoria:</label>
        <input type="text" name="categoria" required>
        <br><br>

        <label>Preço:</label>
        <input type="number" name="preco" step="0.01" min="0" required>
        <br><br>

        <label>Quantidade:</label>
        <input type="number" name="quantidade" min="0" required>
        <br><br>

        <button type="submit">Salvar instrumento</button>
    </form>

    <br>
    <a href="index.jsp">Voltar ao início</a>
</body>
</html>
