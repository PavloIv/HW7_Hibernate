package ua.ip.hw7.controller.developers;

import ua.ip.hw7.dao.ProjectsDao;
import ua.ip.hw7.storage.HibernateProvider;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/developers/salaryOnProjectForm")
public class SalaryOnProjectController extends HttpServlet {
    private ProjectsDao projectsDao;

    @Override
    public void init() throws ServletException {
        HibernateProvider dbProvider = new HibernateProvider();
        projectsDao = new ProjectsDao(dbProvider);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Integer> projectIds = projectsDao.findAllId();
        req.setAttribute("projectIds", projectIds);
        req.getRequestDispatcher("/WEB-INF/jsp/developers/salaryOnProjectForm.jsp").forward(req,resp);
    }
}
