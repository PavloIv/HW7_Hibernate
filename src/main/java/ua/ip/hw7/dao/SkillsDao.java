package ua.ip.hw7.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.ip.hw7.storage.HibernateProvider;
import ua.ip.hw7.table.Skills;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SkillsDao implements ServiceCrud<Skills> {
    private final HibernateProvider sessionManager;

    public SkillsDao(HibernateProvider sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public void create(Skills entity) {
        try(Session session = sessionManager.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
        }
    }

    @Override
    public Skills findById(Integer id) throws SQLException {
        try (Session session = sessionManager.openSession()){
            Skills skill = session.get(Skills.class,id);
            session.close();
            return skill;
        }
    }

    @Override
    public void update(Skills entity) {
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
            Skills skill = session.get(Skills.class,id);
            session.delete(skill);
            transaction.commit();
        }
    }

    public List<String> findAllLanguage() {
        try (Session session = sessionManager.openSession()){
            return new ArrayList<>(session.createQuery("SELECT  DISTINCT s.language FROM Skills s")
                    .getResultList());
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return new ArrayList<>();
    }

    public List<Integer> findAllId() {
        try (Session session = sessionManager.openSession()){

            return new ArrayList<>(session.createQuery("SELECT  DISTINCT p.id FROM Skills p ORDER BY p.id")
                    .getResultList());
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return new ArrayList<>();
    }
}
