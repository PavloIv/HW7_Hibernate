package ua.ip.hw6.controller.developers;

import ua.ip.hw6.dao.DevelopersDao;
import ua.ip.hw6.storage.DatabaseInitConnection;
import ua.ip.hw6.storage.DatabaseSqlManagerConnector;
import ua.ip.hw6.table.Developers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/developers/deleteDevelopers")
public class DeleteDevelopers extends HttpServlet {
    DevelopersDao developersDao;
    @Override
    public void init() throws ServletException {
        DatabaseSqlManagerConnector initConnection = DatabaseInitConnection.getInitService();
        developersDao = new DevelopersDao(initConnection);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer developerId = Integer.valueOf(req.getParameter("developerId"));
        developersDao.delete(developerId);
        req.getRequestDispatcher("/WEB-INF/jsp/developers/deleteDevelopers.jsp").forward(req, resp);
    }
}
