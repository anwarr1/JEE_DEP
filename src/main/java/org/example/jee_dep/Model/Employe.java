package org.example.jee_dep.Model;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name = "employe")
public class Employe {
    String name;
    String email;

    @ManyToMany
    @JoinTable(name = "employees_skills",
            joinColumns = @JoinColumn(name = "idEmployee "),
            inverseJoinColumns = @JoinColumn(name = "idSkill"))
    ArrayList<Skill> skills;
    @ManyToMany
    @JoinTable(name = "employees_project",
            joinColumns = @JoinColumn(name = "idEmployee"),
            inverseJoinColumns = @JoinColumn(name = "idProject"))
    ArrayList<Project> projects;
    @OneToMany(mappedBy = "employee")

    public ArrayList<EmployeesProject> EmployeesProject;



    public boolean EmptyProjects() {
        return EmployeesProject == null || EmployeesProject.isEmpty();
    }

    public ArrayList<EmployeesProject> getEmployeesProject() {
        return EmployeesProject;
    }

    public void setEmployeesProject(ArrayList<EmployeesProject> employeesProject) {
        EmployeesProject = employeesProject;
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }

    public void setProjects(ArrayList<Project> projects) {
        this.projects = projects;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    public Employe(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Employe() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Skill> getSkills() {
        return skills;
    }

    public void setSkills(ArrayList<Skill> skills) {
        this.skills = skills;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

















