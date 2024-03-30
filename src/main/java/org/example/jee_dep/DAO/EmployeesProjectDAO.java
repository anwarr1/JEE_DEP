package org.example.jee_dep.DAO;

import org.example.jee_dep.Model.EmployeesProject;

import java.util.ArrayList;

public interface EmployeesProjectDAO {
    public void save(EmployeesProject employe);
    public ArrayList<EmployeesProject> findAll();
    public void delete(EmployeesProject employe);
    public EmployeesProject find(int id);
}
