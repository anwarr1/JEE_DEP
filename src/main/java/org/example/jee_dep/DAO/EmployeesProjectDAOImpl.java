package org.example.jee_dep.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import org.example.jee_dep.Model.EmployeesProject;

import java.util.ArrayList;

public class EmployeesProjectDAOImpl implements EmployeesProjectDAO {
    EntityManagerFactory entityManagerFactory;
    EntityManager em;

    public EmployeesProjectDAOImpl() {
        entityManagerFactory = Persistence.createEntityManagerFactory("myPU");
        em = entityManagerFactory.createEntityManager();
    }

    @Override
    public void save(EmployeesProject employe) {
        em.getTransaction().begin();
        em.persist(employe);
        em.getTransaction().commit();

    }

    @Override
    public ArrayList<EmployeesProject> findAll() {
        Query EmployeesProject = em.createQuery("SELECT e FROM EmployeesProject e"
        );
        return new ArrayList<>(EmployeesProject.getResultList());

    }

    @Override
    public void delete(EmployeesProject employe) {

    }

    @Override
    public EmployeesProject find(int id) {
        return em.find(EmployeesProject.class, id);

    }
}
