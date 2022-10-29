package ua.ip.hw7.controller.companies;

import lombok.SneakyThrows;
import ua.ip.hw7.dao.CompaniesDAO;
import ua.ip.hw7.storage.HibernateProvider;
import ua.ip.hw7.table.Companies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(urlPatterns = "/companies/findCompany")
public class FindCompany extends HttpServlet {
    CompaniesDAO companiesDAO;
    @Override
    public void init() throws ServletException {
        HibernateProvider dbProvider = new HibernateProvider();
        companiesDAO = new CompaniesDAO(dbProvider);
    }
    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String companyId = req.getParameter("companyId");
        Companies company = companiesDAO.findById(Integer.valueOf(companyId));
        req.setAttribute("company", company);
        req.getRequestDispatcher("/WEB-INF/jsp/companies/findCompany.jsp").forward(req, resp);
    }
}
