
package controller;

import dao.InstrumentoDAO;
import java.io.IOException;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/listar")
public class ListarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        try {
            request.setAttribute(
                "instrumentos",
                new InstrumentoDAO().listar()
            );

            request.getRequestDispatcher("/listar.jsp")
                    .forward(request, response);

        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
