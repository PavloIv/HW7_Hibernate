package ua.ip.hw6.controller.projects;

import ua.ip.hw6.dao.ProjectsDao;
import ua.ip.hw6.storage.DatabaseInitConnection;
import ua.ip.hw6.storage.DatabaseSqlManagerConnector;
import ua.ip.hw6.table.Projects;

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
        DatabaseSqlManagerConnector initConnection = DatabaseInitConnection.getInitService();
        projectsDao = new ProjectsDao(initConnection);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String projectName = req.getParameter("projectName");
        String projectDescription = req.getParameter("projectDescription");
        Integer companyId = Integer.valueOf(req.getParameter("companyId"));
        Integer customerId = Integer.valueOf(req.getParameter("customerId"));


        Projects project = new Projects();
        project.setName(projectName);
        project.setDescription(projectDescription);
        project.setCompany_id(companyId);
        project.setCustomer_id(customerId);

        if (projectsDao.create(project)) {
            req.getRequestDispatcher("/WEB-INF/jsp/projects/createProject.jsp").forward(req, resp);
        }
    }
}
