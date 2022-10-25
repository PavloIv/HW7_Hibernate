package ua.ip.hw6.dao;

import java.sql.SQLException;
import java.util.List;

public interface ServiceCrud<T> {
    void create(T entity);

    T findById(Integer id) throws SQLException;

    List<T> findAll();

    boolean update(T entity);

    boolean delete(Integer id);
}
