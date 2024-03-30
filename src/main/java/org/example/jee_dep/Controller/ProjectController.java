package org.example.jee_dep.Controller;

import jakarta.annotation.ManagedBean;
import org.example.jee_dep.DAO.ProjectDAOImpl;
import org.example.jee_dep.Model.Project;
import org.example.jee_dep.Service.ProjectService;

import java.util.ArrayList;

@ManagedBean

public class ProjectController {
    ArrayList<Project> projects;
    ArrayList<String> implications;
    String name;
    Project projectAffected;
    String implicationAffected;
    ProjectService projectService;
    ProjectDAOImpl projectDAOImpl;
    String SkillsName;

    public ProjectController() {
        this.projectDAOImpl = new ProjectDAOImpl();
        this.projectService = new ProjectService(this.projectDAOImpl);
    }

    public ArrayList<String> getImplications() {
        implications = new ArrayList<>();
        implications.add("20%");
        implications.add("50%");
        implications.add("80%");
        return implications;
    }

    public void setImplications(ArrayList<String> implications) {
        this.implications = implications;
    }

    public String getImplicationAffected() {
        return implicationAffected;
    }

    public void setImplicationAffected(String implicationAffected) {
        this.implicationAffected = implicationAffected;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Project getProjectAffected() {
        return projectAffected;
    }

    public void setProjectAffected(Project projectAffected) {
        this.projectAffected = projectAffected;
    }

    public ArrayList<Project> getProjects() {

        return projects = projectService.findAll();
    }

    public void setProjects(ArrayList<Project> projects) {
        this.projects = projects;
    }
}
