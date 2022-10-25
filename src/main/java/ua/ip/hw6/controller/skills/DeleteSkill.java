package ua.ip.hw6.controller.skills;

import ua.ip.hw6.dao.SkillsDao;
import ua.ip.hw6.storage.DatabaseInitConnection;
import ua.ip.hw6.storage.DatabaseSqlManagerConnector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/skills/deleteSkill")
public class DeleteSkill extends HttpServlet {
    SkillsDao skillsDao;
    @Override
    public void init() throws ServletException {
        DatabaseSqlManagerConnector initConnection = DatabaseInitConnection.getInitService();
        skillsDao = new SkillsDao(initConnection);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer skillId = Integer.valueOf(req.getParameter("skillId"));
        skillsDao.delete(skillId);
        req.getRequestDispatcher("/WEB-INF/jsp/developers/deleteDevelopers.jsp").forward(req, resp);
    }
}
