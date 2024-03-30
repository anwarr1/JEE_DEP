package org.example.jee_dep.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "employees_project")
public class EmployeesProject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "idEmployee")
    public Employe employee;
    @ManyToOne
    @JoinColumn(name = "idProject")

    public Project project;

    public void setEmployee(Employe employee) {
        this.employee = employee;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String implication;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employe getEmployee() {
        return employee;
    }

    public void setIdEmployee(Employe Employee) {
        this.employee = Employee;
    }

    public Project getIdProject() {
        return project;
    }

    public void setIdProject(Project project) {
        this.project = project;
    }

    public String getImplication() {
        return implication;
    }

    public void setImplication(String implication) {
        this.implication = implication;
    }
}
