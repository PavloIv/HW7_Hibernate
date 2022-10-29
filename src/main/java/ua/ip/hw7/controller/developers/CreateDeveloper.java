package ua.ip.hw7.controller.developers;

import ua.ip.hw7.dao.DevelopersDao;
import ua.ip.hw7.storage.HibernateProvider;
import ua.ip.hw7.table.Developers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/developers/createDevelopers")
public class CreateDeveloper extends HttpServlet {
    private DevelopersDao developersDao;

    @Override
    public void init() throws ServletException {
        HibernateProvider dbProvider = new HibernateProvider();
        developersDao = new DevelopersDao(dbProvider);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String developerName = req.getParameter("developerName");
        Integer developerAge = Integer.valueOf(req.getParameter("developerAge"));
        String developerSex = req.getParameter("developerSex");
        Integer developerSalary = Integer.valueOf(req.getParameter("developerSalary"));
        Developers developer = new Developers();
        developer.setName(developerName);
        developer.setAge(developerAge);
        developer.setSex(developerSex);
        developer.setSalary(developerSalary);
        developersDao.create(developer);
        req.getRequestDispatcher("/WEB-INF/jsp/developers/createDevelopers.jsp").forward(req, resp);
    }
}
