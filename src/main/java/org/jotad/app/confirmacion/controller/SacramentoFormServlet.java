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
import java.util.Optional;

@WebServlet({"/sacramentos/form"})
public class SacramentoFormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        SacramentoService service = new SacramentoServiceImpl(conn);
        Integer id;
        try {
            id = Integer.parseInt(req.getParameter("id"));
        }catch (NumberFormatException e){
            id = 0;
        }
        Sacramento sacramento = new Sacramento();
        if (id > 0){
            Optional<Sacramento> o = service.byId(id);
            if (o.isPresent()){
                sacramento = o.get();
            }
        }
        req.setAttribute("sacramento", sacramento);
        getServletContext().getRequestDispatcher("/form.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        SacramentoService service = new SacramentoServiceImpl(conn);
        Integer id;
        try {
            id = Integer.parseInt(req.getParameter("id"));
        }catch (NumberFormatException e){
            id = 0;
        }
        String nombre = req.getParameter("nombre");
        Sacramento sacramento = new Sacramento();
        sacramento.setId(id);
        sacramento.setNombre(nombre);
        service.save(sacramento);
        resp.sendRedirect(req.getContextPath() + "/sacramentos");
    }
}
