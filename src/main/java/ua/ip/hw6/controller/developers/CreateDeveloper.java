package ua.ip.hw6.controller.developers;

import ua.ip.hw6.dao.DevelopersDao;
import ua.ip.hw6.storage.DatabaseInitConnection;
import ua.ip.hw6.storage.DatabaseSqlManagerConnector;
import ua.ip.hw6.table.Developers;

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
        DatabaseSqlManagerConnector initConnection = DatabaseInitConnection.getInitService();
        developersDao = new DevelopersDao(initConnection);
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
        if (developersDao.create(developer)) {
            req.getRequestDispatcher("/WEB-INF/jsp/developers/createDevelopers.jsp").forward(req, resp);
        }
    }
}
