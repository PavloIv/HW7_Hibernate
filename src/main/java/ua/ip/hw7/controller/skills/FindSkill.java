package ua.ip.hw7.controller.skills;

import lombok.SneakyThrows;
import ua.ip.hw7.dao.SkillsDao;
import ua.ip.hw7.storage.HibernateProvider;
import ua.ip.hw7.table.Skills;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/skills/findSkill")
public class FindSkill extends HttpServlet {
    SkillsDao skillsDao;
    @Override
    public void init() throws ServletException {
        HibernateProvider dbProvider = new HibernateProvider();
        skillsDao = new SkillsDao(dbProvider);
    }
    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Integer> skillIds = skillsDao.findAllId();
        req.setAttribute("skillIds", skillIds);

        String skillId = req.getParameter("skillId");
        Skills skill = skillsDao.findById(Integer.valueOf(skillId));
        req.setAttribute("skill", skill);
        req.getRequestDispatcher("/WEB-INF/jsp/skills/findSkill.jsp").forward(req, resp);
    }
}
