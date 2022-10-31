package ua.ip.hw7.controller.skills;

import ua.ip.hw7.dao.SkillsDao;
import ua.ip.hw7.storage.HibernateProvider;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/skills/findSkillsForm")
public class FindSkillsController extends HttpServlet {
    private SkillsDao skillsDao;
    @Override
    public void init() throws ServletException {
        HibernateProvider dbProvider = new HibernateProvider();
        skillsDao = new SkillsDao(dbProvider);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Integer> skillIds = skillsDao.findAllId();
        req.setAttribute("skillIds", skillIds);

        req.getRequestDispatcher("/WEB-INF/jsp/skills/findSkillsForm.jsp").forward(req,resp);
    }
}
