package ua.ip.hw7.controller.companies;

import ua.ip.hw7.dao.CompaniesDAO;
import ua.ip.hw7.dao.DevelopersDao;
import ua.ip.hw7.storage.HibernateProvider;
import ua.ip.hw7.table.Companies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/companies/deleteCompaniesForm")
public class DeleteCompaniesController extends HttpServlet {
    private CompaniesDAO companiesDAO;
    @Override
    public void init() throws ServletException {
        HibernateProvider dbProvider = new HibernateProvider();
        companiesDAO = new CompaniesDAO(dbProvider);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Integer> companyIds = companiesDAO.findAllId();
        req.setAttribute("companyIds", companyIds);
        req.getRequestDispatcher("/WEB-INF/jsp/companies/deleteCompaniesForm.jsp").forward(req,resp);
    }
}
