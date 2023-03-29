package org.jotad.app.confirmacion.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jotad.app.confirmacion.models.Sacramento;
import org.jotad.app.confirmacion.service.SacramentoService;
import org.jotad.app.confirmacion.service.SacramentoServiceImpl;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet({"/sacramentos", "/index.html"})
public class SacramentoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        SacramentoService service = new SacramentoServiceImpl(conn);
        List<Sacramento> sacramentos = service.list("");
        req.setAttribute("sacramentos", sacramentos);
        getServletContext().getRequestDispatcher("/listar.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        SacramentoService service = new SacramentoServiceImpl(conn);
        String nombre = req.getParameter("nombre");

        List<Sacramento> sacramentos = service.list(nombre);
        req.setAttribute("sacramentos", sacramentos);
        getServletContext().getRequestDispatcher("/listar.jsp").forward(req,resp);
    }
}
