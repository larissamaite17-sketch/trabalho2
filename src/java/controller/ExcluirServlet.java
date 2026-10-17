
package controller;

import dao.InstrumentoDAO;
import java.io.IOException;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/excluir")
public class ExcluirServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            new InstrumentoDAO().excluir(id);
            response.sendRedirect("listar");

        } catch (SQLException | NumberFormatException e) {
            throw new ServletException("Erro ao excluir instrumento", e);
        }
    }
}
