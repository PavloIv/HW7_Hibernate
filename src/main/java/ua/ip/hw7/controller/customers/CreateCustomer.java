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

@WebServlet(urlPatterns = "/customers/createCustomer")
public class CreateCustomer extends HttpServlet {
    private CustomerDao customerDao;
    @Override
    public void init() throws ServletException {
        HibernateProvider dbProvider = new HibernateProvider();
        customerDao = new CustomerDao(dbProvider);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String customerName = req.getParameter("customerName");
        String customerWebsite = req.getParameter("customerWebsite");

        Customers customer = new Customers();
        customer.setName(customerName);
        customer.setWebsite(customerWebsite);
        customerDao.create(customer);
        req.getRequestDispatcher("/WEB-INF/jsp/customers/createCustomer.jsp").forward(req, resp);
    }
}
