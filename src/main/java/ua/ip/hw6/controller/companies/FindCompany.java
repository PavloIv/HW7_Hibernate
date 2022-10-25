package ua.ip.hw6.controller.companies;

import ua.ip.hw6.dao.CompaniesDAO;
import ua.ip.hw6.storage.DatabaseInitConnection;
import ua.ip.hw6.storage.DatabaseSqlManagerConnector;
import ua.ip.hw6.table.Companies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/companies/findCompany")
public class FindCompany extends HttpServlet {
    CompaniesDAO companiesDAO;
    @Override
    public void init() throws ServletException {
        DatabaseSqlManagerConnector initConnection = DatabaseInitConnection.getInitService();
        companiesDAO = new CompaniesDAO(initConnection);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer companyId = Integer.valueOf(req.getParameter("companyId"));
        Companies company = companiesDAO.findById(companyId);
        req.setAttribute("company", company);
        req.getRequestDispatcher("/WEB-INF/jsp/companies/findCompany.jsp").forward(req, resp);
    }
}
