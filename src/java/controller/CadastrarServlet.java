
package controller;

import dao.InstrumentoDAO;
import java.io.IOException;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Instrumento;

@WebServlet("/cadastrar")
public class CadastrarServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        Instrumento instrumento = new Instrumento();
        instrumento.setNome(request.getParameter("nome"));
        instrumento.setMarca(request.getParameter("marca"));
        instrumento.setCategoria(request.getParameter("categoria"));
        instrumento.setPreco(Double.parseDouble(
                request.getParameter("preco")));
        instrumento.setQuantidade(Integer.parseInt(
                request.getParameter("quantidade")));

        try {
            InstrumentoDAO dao = new InstrumentoDAO();
            dao.cadastrar(instrumento);
            response.sendRedirect("listar");

        } catch (SQLException e) {
            throw new ServletException("Erro ao salvar instrumento", e);
        }
    }
}
