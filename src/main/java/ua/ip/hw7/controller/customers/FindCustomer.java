package ua.ip.hw7.controller.customers;

import lombok.SneakyThrows;
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

@WebServlet(urlPatterns = "/customers/findCustomer")
public class FindCustomer extends HttpServlet {
    private CustomerDao customerDao;
    @Override
    public void init() throws ServletException {
        HibernateProvider dbProvider = new HibernateProvider();
        customerDao = new CustomerDao(dbProvider);
    }

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Integer> customerIds = customerDao.findAllId();
        req.setAttribute("customerIds", customerIds);

        Integer customerId = Integer.valueOf(req.getParameter("customerId"));
        Customers customer = customerDao.findById(customerId);
        req.setAttribute("customer", customer);
        req.getRequestDispatcher("/WEB-INF/jsp/customers/findCustomer.jsp").forward(req, resp);
    }
}
