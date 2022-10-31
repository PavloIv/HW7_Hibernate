package ua.ip.hw7.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ua.ip.hw7.storage.HibernateProvider;
import ua.ip.hw7.table.Customers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao implements ServiceCrud<Customers>{
    private final HibernateProvider sessionManager;

    public CustomerDao(HibernateProvider sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public void create(Customers entity) {
        try (Session session = sessionManager.openSession()){
            Transaction transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
        }
    }

    @Override
    public Customers findById(Integer id) throws SQLException {
        try(Session session = sessionManager.openSession()){
            Customers  customer = session.get(Customers.class,id);
            session.close();
            return customer;
        }
    }
    @Override
    public void update(Customers entity) {
        try (Session session = sessionManager.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(entity);
            transaction.commit();
        }
    }

    @Override
    public void delete(Integer id) {
        try(Session session = sessionManager.openSession()){
            Transaction transaction = session.beginTransaction();
            Customers customer =session.get(Customers.class,id);
            session.delete(customer);
            transaction.commit();
        }
    }

    public List<Integer> findAllId() {
        try (Session session = sessionManager.openSession()){
            return new ArrayList<>(session.createQuery("SELECT DISTINCT c.id FROM Customers c ORDER BY c.id")
                    .getResultList());
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return new ArrayList<>();
    }

}
