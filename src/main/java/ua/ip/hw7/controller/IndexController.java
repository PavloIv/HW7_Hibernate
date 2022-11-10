package ua.ip.hw7.controller;

import ua.ip.hw7.storage.DatabaseInitService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/")
public class IndexController extends HttpServlet {
    @Override
    public void init() throws ServletException {
        new DatabaseInitService().initDb("jdbc:postgresql://localhost:5432/GrafProductCompany"
                ,"YourUsername"
                ,"YourPassword");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(req, resp);
    }
}
