package ua.ip.hw7.controller.developers;

import ua.ip.hw7.dao.DevelopersDao;
import ua.ip.hw7.storage.HibernateProvider;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/developers/deleteDevelopersForm")
public class DeleteDevelopersController extends HttpServlet {
    private DevelopersDao developersDao;

    @Override
    public void init() throws ServletException {
        HibernateProvider dbProvider = new HibernateProvider();
        developersDao = new DevelopersDao(dbProvider);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Integer> developerIds = developersDao.findAllId();
        req.setAttribute("developerIds", developerIds);
        req.getRequestDispatcher("/WEB-INF/jsp/developers/deleteDevelopersForm.jsp").forward(req,resp);
    }
}
