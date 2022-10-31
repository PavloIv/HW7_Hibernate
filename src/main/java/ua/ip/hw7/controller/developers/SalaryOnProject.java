package ua.ip.hw7.controller.developers;

import ua.ip.hw7.dao.DevelopersDao;
import ua.ip.hw7.dao.ProjectsDao;
import ua.ip.hw7.storage.HibernateProvider;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/developers/salaryOnProject")
public class SalaryOnProject extends HttpServlet {

    private DevelopersDao developersDao;
    private ProjectsDao projectsDao;
    @Override
    public void init() throws ServletException {
        HibernateProvider dbProvider = new HibernateProvider();
        developersDao = new DevelopersDao(dbProvider);
        projectsDao = new ProjectsDao(dbProvider);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Integer> projectIds = projectsDao.findAllId();
        req.setAttribute("projectIds", projectIds);
        Integer developerId = Integer.valueOf(req.getParameter("projectId"));

        Integer salaryOnProject = Math.toIntExact(developersDao.calculateSalaryOnProjectFromId(developerId));
        req.setAttribute("salaryOnProject", salaryOnProject);
        req.getRequestDispatcher("/WEB-INF/jsp/developers/salaryOnProject.jsp").forward(req, resp);
    }

}
