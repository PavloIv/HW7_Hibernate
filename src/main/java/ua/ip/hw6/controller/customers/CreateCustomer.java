package ua.ip.hw6.controller.customers;

import ua.ip.hw6.dao.CustomerDao;
import ua.ip.hw6.storage.DatabaseInitConnection;
import ua.ip.hw6.storage.DatabaseSqlManagerConnector;
import ua.ip.hw6.table.Customers;

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
        DatabaseSqlManagerConnector initConnection = DatabaseInitConnection.getInitService();
        customerDao = new CustomerDao(initConnection);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String customerName = req.getParameter("customerName");
        String customerWebsite = req.getParameter("customerWebsite");

        Customers customer = new Customers();
        customer.setName(customerName);
        customer.setWebsite(customerWebsite);
        if (customerDao.create(customer)) {
            req.getRequestDispatcher("/WEB-INF/jsp/customers/createCustomer.jsp").forward(req, resp);
        }
    }
}
