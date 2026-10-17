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

@WebServlet("/editar")
public class EditarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));

            InstrumentoDAO dao = new InstrumentoDAO();
            Instrumento instrumento = dao.buscarPorId(id);

            if (instrumento == null) {
                response.sendRedirect("listar");
                return;
            }

            request.setAttribute("instrumento", instrumento);
            request.getRequestDispatcher("/editar.jsp")
                    .forward(request, response);

        } catch (SQLException | NumberFormatException e) {
            throw new ServletException("Erro ao buscar instrumento", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        try {
            Instrumento i = new Instrumento();
            i.setId(Integer.parseInt(request.getParameter("id")));
            i.setNome(request.getParameter("nome"));
            i.setMarca(request.getParameter("marca"));
            i.setCategoria(request.getParameter("categoria"));
            i.setPreco(Double.parseDouble(request.getParameter("preco")));
            i.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));

            new InstrumentoDAO().atualizar(i);
            response.sendRedirect("listar");

        } catch (SQLException | NumberFormatException e) {
            throw new ServletException("Erro ao editar instrumento", e);
        }
    }
}