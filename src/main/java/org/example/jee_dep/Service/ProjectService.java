package org.example.jee_dep.Service;

import org.example.jee_dep.DAO.ProjectDAOImpl;
import org.example.jee_dep.Model.Project;

import java.util.ArrayList;

public class ProjectService {
    ProjectDAOImpl projectDAOImp;

    public ProjectService(ProjectDAOImpl projectDAOImp) {
        this.projectDAOImp = projectDAOImp;
    }

    public void save(Project project) {

        projectDAOImp.save(project);
    }

    public ArrayList<Project> findAll() {
        return projectDAOImp.findAll();
    }

    public void delete(int id) {

        projectDAOImp.delete(projectDAOImp.find(id));
    }
}
