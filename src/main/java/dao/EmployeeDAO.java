package dao;

import entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    void createOne(Employee employee);

    List<Employee> getAll();

    Employee findById(Long id);

    void updateOne(Employee employee);

    void deleteOne(Employee employee);
}
