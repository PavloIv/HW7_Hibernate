package ua.ip.hw6.controller.customers;

import ua.ip.hw6.dao.CustomerDao;
import ua.ip.hw6.dao.DevelopersDao;
import ua.ip.hw6.storage.DatabaseInitConnection;
import ua.ip.hw6.storage.DatabaseSqlManagerConnector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/customers/deleteCustomer")
public class DeleteCustomer extends HttpServlet {
    CustomerDao customerDao;
    @Override
    public void init() throws ServletException {
        DatabaseSqlManagerConnector initConnection = DatabaseInitConnection.getInitService();
        customerDao= new CustomerDao(initConnection);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer customerId = Integer.valueOf(req.getParameter("customerId"));
        customerDao.delete(customerId);
        req.getRequestDispatcher("/WEB-INF/jsp/customers/deleteCustomer.jsp").forward(req, resp);
    }
}
