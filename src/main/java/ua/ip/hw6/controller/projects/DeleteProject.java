package ua.ip.hw6.controller.projects;

import ua.ip.hw6.dao.ProjectsDao;
import ua.ip.hw6.storage.DatabaseInitConnection;
import ua.ip.hw6.storage.DatabaseSqlManagerConnector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/projects/deleteProject")
public class DeleteProject extends HttpServlet {
    ProjectsDao projectsDao;
    @Override
    public void init() throws ServletException {
        DatabaseSqlManagerConnector initConnection = DatabaseInitConnection.getInitService();
        projectsDao = new ProjectsDao(initConnection);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer projectId = Integer.valueOf(req.getParameter("projectId"));
        projectsDao.delete(projectId);
        req.getRequestDispatcher("/WEB-INF/jsp/projects/deleteProject.jsp").forward(req, resp);
    }
}
