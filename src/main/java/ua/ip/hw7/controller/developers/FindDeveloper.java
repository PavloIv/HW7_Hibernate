package ua.ip.hw7.controller.developers;

import lombok.SneakyThrows;
import ua.ip.hw7.dao.DevelopersDao;
import ua.ip.hw7.storage.HibernateProvider;
import ua.ip.hw7.table.Developers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/developers/findDevelopers")
public class FindDeveloper extends HttpServlet {
    private DevelopersDao developersDao;
    @Override
    public void init() throws ServletException {
        HibernateProvider dbProvider = new HibernateProvider();
        developersDao = new DevelopersDao(dbProvider);
    }

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Integer> developerIds = developersDao.findAllId();
        req.setAttribute("developerIds", developerIds);

        String developerId = req.getParameter("developerId");
        Developers developers = developersDao.findById(Integer.valueOf(developerId));
        req.setAttribute("developers", developers);
        req.getRequestDispatcher("/WEB-INF/jsp/developers/findDevelopers.jsp").forward(req, resp);
    }
}
