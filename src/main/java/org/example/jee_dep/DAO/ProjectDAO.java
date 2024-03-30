package org.example.jee_dep.DAO;

import org.example.jee_dep.Model.Project;

import java.util.ArrayList;

public interface ProjectDAO {
    void save(Project project);

    public ArrayList<Project> findAll();

    public void delete(Project project);
    public Project find(int id);

}
