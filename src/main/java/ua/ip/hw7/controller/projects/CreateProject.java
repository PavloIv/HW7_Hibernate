package ua.ip.hw7.controller.projects;

import ua.ip.hw7.dao.ProjectsDao;
import ua.ip.hw7.storage.HibernateProvider;
import ua.ip.hw7.table.Projects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/projects/createProject")
public class CreateProject extends HttpServlet {
    ProjectsDao projectsDao;
    @Override
    public void init() throws ServletException {
        HibernateProvider dbProvider = new HibernateProvider();
        projectsDao = new ProjectsDao(dbProvider);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String projectName = req.getParameter("projectName");
        String projectDescription = req.getParameter("projectDescription");

        Projects project = new Projects();
        project.setName(projectName);
        project.setDescription(projectDescription);

        projectsDao.create(project);
        req.getRequestDispatcher("/WEB-INF/jsp/projects/createProject.jsp").forward(req, resp);
    }
}
