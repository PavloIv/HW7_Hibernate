package ua.ip.hw6.controller.customers;

import ua.ip.hw6.dao.CustomerDao;
import ua.ip.hw6.dao.DevelopersDao;
import ua.ip.hw6.storage.DatabaseInitConnection;
import ua.ip.hw6.storage.DatabaseSqlManagerConnector;
import ua.ip.hw6.table.Customers;
import ua.ip.hw6.table.Developers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/customers/findCustomer")
public class FindCustomer extends HttpServlet {
    private CustomerDao customerDao;
    @Override
    public void init() throws ServletException {
        DatabaseSqlManagerConnector initConnection = DatabaseInitConnection.getInitService();
        customerDao = new CustomerDao(initConnection);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer customerId = Integer.valueOf(req.getParameter("customerId"));
        Customers customer = customerDao.findById(customerId);
        req.setAttribute("customer", customer);
        req.getRequestDispatcher("/WEB-INF/jsp/customers/findCustomer.jsp").forward(req, resp);
    }
}
