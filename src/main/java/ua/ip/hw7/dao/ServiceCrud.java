package ua.ip.hw7.dao;

import java.sql.SQLException;
import java.util.List;

public interface ServiceCrud<T> {
    void create(T entity);

    T findById(Integer id) throws SQLException;

    void update(T entity);

    void delete(Integer id);

}
