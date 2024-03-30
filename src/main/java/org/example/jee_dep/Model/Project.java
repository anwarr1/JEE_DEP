package org.example.jee_dep.Model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Objects;

@Entity
@Table(name = "project")
public class Project {
    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    @OneToMany(mappedBy = "project")
    public ArrayList<EmployeesProject> EmployeesProject;
    String name;
    double budget;
    @ManyToMany(mappedBy = "projects")

    ArrayList<Employe> employes;

    public ArrayList<Employe> getEmployes() {
        return employes;
    }

    public void setEmployes(ArrayList<Employe> employes) {
        this.employes = employes;
    }

    @Id
    private Long id;

    public Project(String name, double budegt) {
        this.name = name;
        this.budget = budegt;
    }
    public Project() {

    }

    public ArrayList<EmployeesProject> getEmployeesProject() {
        return EmployeesProject;
    }

    public void setEmployeesProject(ArrayList<EmployeesProject> employeesProject) {
        EmployeesProject = employeesProject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBudegt() {
        return budget;
    }

    public void setBudegt(double budegt) {
        this.budget = budegt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(id, project.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
