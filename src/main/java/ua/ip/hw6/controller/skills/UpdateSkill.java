package ua.ip.hw6.controller.skills;

import ua.ip.hw6.dao.SkillsDao;
import ua.ip.hw6.storage.DatabaseInitConnection;
import ua.ip.hw6.storage.DatabaseSqlManagerConnector;
import ua.ip.hw6.table.Skills;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/skills/updateSkill")
public class UpdateSkill extends HttpServlet {
    SkillsDao skillsDao;
    @Override
    public void init() throws ServletException {
        DatabaseSqlManagerConnector initConnection = DatabaseInitConnection.getInitService();
        skillsDao = new SkillsDao(initConnection);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer skillId = Integer.valueOf(req.getParameter("skillId"));
        String language = req.getParameter("language");
        String level = req.getParameter("level");

        Skills skill = new Skills();
        skill.setId(skillId);
        skill.setLanguage(language);
        skill.setLevel(level);

        if (skillsDao.update(skill)) {
            req.getRequestDispatcher("/WEB-INF/jsp/skills/createSkill.jsp").forward(req, resp);
        }
    }
}
