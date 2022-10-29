package ua.ip.hw7.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import ua.ip.hw7.storage.HibernateProvider;
import ua.ip.hw7.table.Projects;

import java.sql.SQLException;


public class ProjectsDao implements ServiceCrud<Projects> {
    private final HibernateProvider sessionManager;

    public ProjectsDao(HibernateProvider sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public void create(Projects entity) {
        try (Session session = sessionManager.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
        }
    }

    @Override
    public Projects findById(Integer id) throws SQLException {
        try (Session session = sessionManager.openSession()) {
            Projects project = session.get(Projects.class, id);
            session.close();
            return project;
        }
    }

    @Override
    public void update(Projects entity) {
        try (Session session = sessionManager.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(entity);
            transaction.commit();
        }
    }

    @Override
    public void delete(Integer id) {
        try (Session session = sessionManager.openSession()) {
            Transaction transaction = session.beginTransaction();
            Projects project = session.get(Projects.class, id);
            session.delete(project);
            transaction.commit();
        }
    }

}
