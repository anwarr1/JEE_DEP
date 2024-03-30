package org.example.jee_dep.DAO;

import org.example.jee_dep.Model.Employe;

import java.util.ArrayList;

public interface EmployeeDAO {
    public void save(Employe employe);
    public ArrayList<Employe> findAll();
    public void delete(Employe employe);
    public Employe find(Long id);
}
