package dao;

import entity.EmplProj;

import java.sql.SQLException;
import java.util.List;

public interface EmplProjDAO {
    void createOne(EmplProj emplProj) throws SQLException;

    List<EmplProj> getAll() throws SQLException;

    EmplProj findByEmployeeIdAndProjectId(Long employeeId, Long projectId) throws SQLException;

    void updateOne(EmplProj emplProj) throws SQLException;

    void deleteOne(EmplProj emplProj) throws SQLException;
}
