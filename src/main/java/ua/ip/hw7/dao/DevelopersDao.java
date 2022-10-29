package ua.ip.hw7.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.ip.hw7.storage.HibernateProvider;
import ua.ip.hw7.table.Developers;

import javax.persistence.Query;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DevelopersDao implements ServiceCrud<Developers> {
    private final HibernateProvider sessionManager;

    public DevelopersDao(HibernateProvider sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public void create(Developers entity) {
        try (Session session = sessionManager.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
        }
    }

    @Override
    public Developers findById(Integer id) throws SQLException {
        try (Session session = sessionManager.openSession()) {
            Developers developer = session.get(Developers.class, id);
            session.close();
            return developer;
        }
    }

    @Override
    public void update(Developers entity) {
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
            Developers developer = session.get(Developers.class, id);
            session.delete(developer);
            transaction.commit();
        }
    }

        public Integer calculateSalaryOnProjectFromId(Integer projectId) {
            try (Session session = sessionManager.openSession()){
                Transaction transaction = session.beginTransaction();
                Query query = session.createQuery("SELECT SUM(d.salary) FROM Developers d " +
                        "JOIN d.projects p WHERE p.id = :projectId").setParameter("projectId",projectId);
                transaction.commit();


                return Integer.valueOf(String.valueOf(query.getResultList().get(0)));
            }
    }
    public List<Developers> showProgrammerOnProjectFromProjectId(Integer projectId) {
        try (Session session = sessionManager.openSession()) {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("SELECT d FROM Developers d  JOIN d.projects p " +
                            "WHERE p.id = :projectId")
                    .setParameter("projectId", projectId);
            transaction.commit();

            return new ArrayList<Developers>(query.getResultList());

        }
    }

    public List<Developers> showProgrammerOnLanguage(String language) {
        try (Session session = sessionManager.openSession()) {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("SELECT d FROM Developers d  JOIN d.skills s " +
                            "WHERE s.language LIKE :language")
                    .setParameter("language", language);
            transaction.commit();

            return new ArrayList<Developers>(query.getResultList());

        }
    }
}
