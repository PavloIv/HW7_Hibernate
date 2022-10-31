package ua.ip.hw7.controller.companies;

import ua.ip.hw7.dao.CompaniesDAO;
import ua.ip.hw7.table.Companies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/companies/updateCompany")
public class UpdateCompany extends HttpServlet {
    CompaniesDAO companiesDAO;
    @Override
    public void init() throws ServletException {
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Integer> companyIds = companiesDAO.findAllId();
        req.setAttribute("companyIds", companyIds);

        Integer companyId = Integer.valueOf(req.getParameter("companyId"));
        String companyName = req.getParameter("companyName");
        Integer companyYearFoundation = Integer.valueOf(req.getParameter("companyYearFoundation"));

        Companies company = new Companies();
        company.setId(companyId);
        company.setName(companyName);
        company.setYearOfFoundation(companyYearFoundation);

        companiesDAO.update(company);
            req.getRequestDispatcher("/WEB-INF/jsp/companies/updateCompany.jsp").forward(req, resp);
    }
}
