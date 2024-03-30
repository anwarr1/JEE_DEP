package org.example.jee_dep.Controller;

import jakarta.annotation.ManagedBean;
import org.example.jee_dep.DAO.EmployeDAOImpl;
import org.example.jee_dep.DAO.EmployeesProjectDAOImpl;
import org.example.jee_dep.Model.Employe;
import org.example.jee_dep.Model.EmployeesProject;
import org.example.jee_dep.Model.Project;
import org.example.jee_dep.Model.Skill;
import org.example.jee_dep.Service.EmployeService;
import org.example.jee_dep.Service.EmployeesProjectService;

import java.util.ArrayList;

@ManagedBean
public class EmployeeController {

    ArrayList<Skill> selectedSkills;

    int id;
    String name;
    String email;
    ArrayList<Project> projectsAffected;
    String implicationAffected;
    ArrayList<Employe> employes;
    String employeAffected;
    EmployeService employeService;
    EmployeDAOImpl employeDAOImpl;
    EmployeesProjectService employeesProjectService;
    EmployeesProjectDAOImpl employeesProjectDAOImpl;
    String message = "";
    boolean emptyM;

    public EmployeeController() {
        this.employeDAOImpl = new EmployeDAOImpl();
        this.employeService = new EmployeService(this.employeDAOImpl);
        this.employeesProjectDAOImpl = new EmployeesProjectDAOImpl();
        this.employeesProjectService = new EmployeesProjectService(this.employeesProjectDAOImpl);
    }

    public boolean isEmptyM() {
        return emptyM;
    }

    public void setEmptyM(boolean emptyM) {
        this.emptyM = emptyM;
    }

    public ArrayList<Employe> getEmployes() {
        return employes = employeService.findAll();
    }

    public void setEmployes(ArrayList<Employe> employes) {
        this.employes = employes;
    }


    public String getEmployeAffected() {
        return employeAffected;
    }

    public void setEmployeAffected(String employeAffected) {
        this.employeAffected = employeAffected;
    }

    public String getImplicationAffected() {
        return implicationAffected;
    }

    public void setImplicationAffected(String implicationAffected) {
        this.implicationAffected = implicationAffected;
    }

    public ArrayList<Project> getProjectsAffected() {
        return projectsAffected;
    }

    public void setProjectsAffected(ArrayList<Project> projectAffected) {
        this.projectsAffected = projectAffected;
    }

    public ArrayList<Skill> getSelectedSkills() {
        return selectedSkills;
    }

    public void setSelectedSkills(ArrayList<Skill> selectedSkills) {
        this.selectedSkills = selectedSkills;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String save() {
        System.out.println("saved soon");

        Employe employe = new Employe(name, email);
        for (Skill s : selectedSkills) {
            System.out.println(s.getName());
        }
        employe.setSkills(selectedSkills);
        System.out.println(employe.getEmail());
        System.out.println(employe.getName());
        employeService.save(employe);
        return "home.xhtml";

    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String affect() {
        Employe employe = employeService.find(Long.parseLong(employeAffected));
        ArrayList<Project> projectss = employe.getProjects();
        employeDAOImpl.getEm().getTransaction().begin();

        for (Project p : projectsAffected) {

            if (projectss.contains(p)) {
                System.out.println("Yes contains");

                setMessage("Deja Affeceté !");
                return "affectation.xhtml";
            } else {
                EmployeesProject employeesProject = new EmployeesProject();
                employeesProject.setIdEmployee(employe);

                employeesProject.setIdProject(p);
                employeesProject.setImplication(implicationAffected);
                employeesProjectService.save(employeesProject);

            }
        }
        employeDAOImpl.getEm().getTransaction().commit();
        employeDAOImpl.getEm().refresh(employe);
        return "home.xhtml";
    }

    public  void delete(long id) {
        Employe employe = employeService.find((Long) id);

        employe.getProjects().clear();
        employe.getSkills().clear();

        employeService.delete(employe.getId());

    }
}


