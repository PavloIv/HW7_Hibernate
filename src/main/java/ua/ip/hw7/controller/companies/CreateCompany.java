package ua.ip.hw7.controller.companies;

import ua.ip.hw7.dao.CompaniesDAO;
import ua.ip.hw7.storage.HibernateProvider;
import ua.ip.hw7.table.Companies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/companies/createCompany")
public class CreateCompany extends HttpServlet {
    CompaniesDAO companiesDAO;

    @Override
    public void init() throws ServletException {
        HibernateProvider dbProvider = new HibernateProvider();
        companiesDAO = new CompaniesDAO(dbProvider);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String companyName = req.getParameter("companyName");
        Integer companyYearFoundation = Integer.valueOf(req.getParameter("companyYearFoundation"));

        Companies company = new Companies();
        company.setName(companyName);
        company.setYearOfFoundation(companyYearFoundation);

        companiesDAO.create(company);
        req.getRequestDispatcher("/WEB-INF/jsp/companies/createCompany.jsp").forward(req, resp);
    }
}
