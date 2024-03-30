package org.example.jee_dep.Service;

import org.example.jee_dep.DAO.EmployeDAOImpl;
import org.example.jee_dep.Model.Employe;

import java.util.ArrayList;

public class EmployeService {
    EmployeDAOImpl employeDAOImp;

    public EmployeService(EmployeDAOImpl employeDAOImp) {
        this.employeDAOImp = employeDAOImp;
    }

    public void save(Employe employe) {

        employeDAOImp.save(employe);
    }
    public ArrayList<Employe> findAll() {
        return employeDAOImp.findAll();
    }

    public void delete(long id) {

        employeDAOImp.delete(employeDAOImp.find(id));
    }
    public Employe find(Long id) {

       return employeDAOImp.find(id);
    }
}
