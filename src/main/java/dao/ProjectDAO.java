package dao;

import entity.Project;

import java.util.List;

public interface ProjectDAO extends CruDDAO<Project, Long> {
    void createOne(Project project);

    List<Project> getAll();

    Project findById(Long id);

    void updateOne(Project project);

    void deleteOne(Project project);
}
