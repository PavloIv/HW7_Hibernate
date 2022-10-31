package ua.ip.hw7.controller.customers;

import ua.ip.hw7.dao.CompaniesDAO;
import ua.ip.hw7.dao.CustomerDao;
import ua.ip.hw7.storage.HibernateProvider;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/customers/findCustomersForm")
public class FindCustomersController extends HttpServlet {
    private CustomerDao customerDao;
    @Override
    public void init() throws ServletException {
        HibernateProvider dbProvider = new HibernateProvider();
        customerDao = new CustomerDao(dbProvider);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Integer> customerIds = customerDao.findAllId();
        req.setAttribute("customerIds", customerIds);

        req.getRequestDispatcher("/WEB-INF/jsp/customers/findCustomersForm.jsp").forward(req,resp);
    }
}
