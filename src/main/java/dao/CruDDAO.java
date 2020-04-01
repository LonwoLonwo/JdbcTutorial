package dao;

import java.sql.SQLException;
import java.util.List;

//один интерфейс, чтоб править всеми
public interface CruDDAO<T, U> {
    void createOne(T object) throws SQLException;
    List<T> getAll() throws SQLException;
    T findById(U id) throws SQLException;
    void updateOne(T object) throws SQLException;
    void deleteOne(T object) throws SQLException;
}
