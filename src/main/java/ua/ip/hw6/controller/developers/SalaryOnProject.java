package ua.ip.hw6.controller.developers;

import ua.ip.hw6.dao.DevelopersDao;
import ua.ip.hw6.storage.DatabaseInitConnection;
import ua.ip.hw6.storage.DatabaseSqlManagerConnector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/developers/salaryOnProject")
public class SalaryOnProject extends HttpServlet {
    private DevelopersDao developersDao;
    @Override
    public void init() throws ServletException {
        DatabaseSqlManagerConnector initConnection = DatabaseInitConnection.getInitService();
        developersDao = new DevelopersDao(initConnection);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/developers/salaryOnProjectForm.jsp").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer developerId = Integer.valueOf(req.getParameter("developerId"));

        Integer salaryOnProject =  developersDao.calculateSalaryOnProjectFromId(developerId);
        req.setAttribute("salaryOnProject", salaryOnProject);
        req.getRequestDispatcher("/WEB-INF/jsp/developers/salaryOnProject.jsp").forward(req, resp);
    }
}
