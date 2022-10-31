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
import java.util.List;

@WebServlet(urlPatterns = "/project/updateProject")
public class UpdateProject extends HttpServlet {
    ProjectsDao projectsDao;
    @Override
    public void init() throws ServletException {
        HibernateProvider dbProvider = new HibernateProvider();
        projectsDao = new ProjectsDao(dbProvider);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Integer> projectIds = projectsDao.findAllId();
        req.setAttribute("projectIds", projectIds);

        Integer projectId = Integer.valueOf(req.getParameter("projectId"));
        String projectName = req.getParameter("projectName");
        String  projectDescription = req.getParameter("projectDescription");
        Integer companyId = Integer.valueOf(req.getParameter("companyId"));
        Integer customerId = Integer.valueOf(req.getParameter("customerId"));

        Projects project = new Projects();
        project.setId(projectId);
        project.setName(projectName);
        project.setDescription(projectDescription);

        projectsDao.update(project);
        req.getRequestDispatcher("/WEB-INF/jsp/projects/updateProject.jsp").forward(req, resp);
    }
}
