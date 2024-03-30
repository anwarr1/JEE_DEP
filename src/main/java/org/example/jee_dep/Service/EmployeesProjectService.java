package org.example.jee_dep.Service;

import org.example.jee_dep.DAO.EmployeesProjectDAOImpl;
import org.example.jee_dep.Model.EmployeesProject;

import java.util.ArrayList;

public class EmployeesProjectService {
    EmployeesProjectDAOImpl employeesProjectDAOImp;

    public EmployeesProjectService(EmployeesProjectDAOImpl employeesProject) {
        this.employeesProjectDAOImp = employeesProject;
    }

    public void save(EmployeesProject employe) {

        employeesProjectDAOImp.save(employe);
    }

    public ArrayList<EmployeesProject> findAll() {
        return employeesProjectDAOImp.findAll();
    }

    public void delete(int id) {

        employeesProjectDAOImp.delete(employeesProjectDAOImp.find(id));
    }
}
