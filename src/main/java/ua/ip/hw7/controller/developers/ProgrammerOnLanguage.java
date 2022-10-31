package ua.ip.hw7.controller.developers;

import ua.ip.hw7.dao.DevelopersDao;
import ua.ip.hw7.dao.SkillsDao;
import ua.ip.hw7.storage.HibernateProvider;
import ua.ip.hw7.table.Developers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/developers/programmerOnLanguage")
public class ProgrammerOnLanguage extends HttpServlet {
    private DevelopersDao developersDao;
    private SkillsDao skillsDao;
    @Override
    public void init() throws ServletException {
        HibernateProvider dbProvider = new HibernateProvider();
        skillsDao = new SkillsDao(dbProvider);
        developersDao = new DevelopersDao(dbProvider);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> languages = skillsDao.findAllLanguage();
        req.setAttribute("languages", languages);

        String language = req.getParameter("language");

        List<Developers> developers =  developersDao.showProgrammerOnLanguage(language);
        req.setAttribute("developers", developers);
        req.getRequestDispatcher("/WEB-INF/jsp/developers/programmerOnLanguage.jsp").forward(req, resp);
    }
}
