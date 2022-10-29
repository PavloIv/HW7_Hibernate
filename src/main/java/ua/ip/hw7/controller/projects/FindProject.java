package ua.ip.hw7.controller.projects;

import lombok.SneakyThrows;
import ua.ip.hw7.dao.ProjectsDao;
import ua.ip.hw7.storage.HibernateProvider;
import ua.ip.hw7.table.Projects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/projects/findProject")
public class FindProject extends HttpServlet {
    ProjectsDao projectsDao;
    @Override
    public void init() throws ServletException {
        HibernateProvider dbProvider = new HibernateProvider();
        projectsDao = new ProjectsDao(dbProvider);
    }

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String projectId = req.getParameter("projectId");
        Projects project = projectsDao.findById(Integer.valueOf(projectId));
        req.setAttribute("project", project);
        req.getRequestDispatcher("/WEB-INF/jsp/projects/findProject.jsp").forward(req, resp);
    }
}
