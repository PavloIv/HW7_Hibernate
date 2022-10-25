package ua.ip.hw6.controller.projects;

import ua.ip.hw6.dao.ProjectsDao;
import ua.ip.hw6.storage.DatabaseInitConnection;
import ua.ip.hw6.storage.DatabaseSqlManagerConnector;
import ua.ip.hw6.table.Developers;
import ua.ip.hw6.table.Projects;

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
        DatabaseSqlManagerConnector initConnection = DatabaseInitConnection.getInitService();
        projectsDao = new ProjectsDao(initConnection);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String projectId = req.getParameter("projectId");
        Projects project = projectsDao.findById(Integer.valueOf(projectId));
        req.setAttribute("project", project);
        req.getRequestDispatcher("/WEB-INF/jsp/projects/findProject.jsp").forward(req, resp);
    }
}
