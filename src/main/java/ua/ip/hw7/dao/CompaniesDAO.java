package ua.ip.hw7.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.ip.hw7.storage.HibernateProvider;
import ua.ip.hw7.table.Companies;
import ua.ip.hw7.table.Developers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompaniesDAO implements ServiceCrud<Companies> {
    private final HibernateProvider sessionManager;

    public CompaniesDAO(HibernateProvider sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public void create(Companies entity) {
        try (Session session = sessionManager.openSession()){
            Transaction transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
        }
    }

    @Override
    public Companies findById(Integer id) throws SQLException {
        try(Session session = sessionManager.openSession()){
            Companies company = session.get(Companies.class,id);
            session.close();
            return company;
        }
    }
    @Override
    public void update(Companies entity) {
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
            Companies company = session.get(Companies.class,id);
            session.delete(company);
            transaction.commit();
        }
    }
    public List<Integer> findAllId() {
        try (Session session = sessionManager.openSession()){
            return new ArrayList<>(session.createQuery("SELECT  DISTINCT c.id FROM Companies c ORDER BY c.id")
                    .getResultList());
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return new ArrayList<>();
    }
}
