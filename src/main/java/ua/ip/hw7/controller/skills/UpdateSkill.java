package ua.ip.hw7.controller.skills;

import ua.ip.hw7.dao.SkillsDao;

import ua.ip.hw7.storage.HibernateProvider;
import ua.ip.hw7.table.Skills;

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
        HibernateProvider dbProvider = new HibernateProvider();
        skillsDao = new SkillsDao(dbProvider);
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

        skillsDao.update(skill);
            req.getRequestDispatcher("/WEB-INF/jsp/skills/createSkill.jsp").forward(req, resp);
    }
}
