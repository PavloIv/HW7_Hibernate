package ua.ip.hw7.controller.customers;

import ua.ip.hw7.dao.CustomerDao;
import ua.ip.hw7.storage.HibernateProvider;
import ua.ip.hw7.table.Customers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/customers/updateCustomer")
public class UpdateCustomer extends HttpServlet {
    private CustomerDao customerDao;
    @Override
    public void init() throws ServletException {
        HibernateProvider dbProvider = new HibernateProvider();
        customerDao = new CustomerDao(dbProvider);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Integer> customerIds = customerDao.findAllId();
        req.setAttribute("customerIds", customerIds);

        Integer customerId = Integer.valueOf(req.getParameter("customerId"));
        String customerName = req.getParameter("customerName");
        String customerWebsite = req.getParameter("customerWebsite");

        Customers customer = new Customers(customerId,customerName,customerWebsite);
        customerDao.update(customer);
            req.getRequestDispatcher("/WEB-INF/jsp/customers/updateCustomer.jsp").forward(req, resp);

    }
}
