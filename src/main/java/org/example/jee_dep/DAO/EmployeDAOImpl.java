package org.example.jee_dep.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import org.example.jee_dep.Model.Employe;

import java.util.ArrayList;

public class EmployeDAOImpl implements EmployeeDAO {
    EntityManagerFactory entityManagerFactory;
    EntityManager em;

    public EmployeDAOImpl() {
        entityManagerFactory = Persistence.createEntityManagerFactory("myPU");
        em = entityManagerFactory.createEntityManager();

    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Override
    public void save(Employe employe) {
        em.getTransaction().begin();
        em.persist(employe);
        em.getTransaction().commit();
    }

    @Override
    public ArrayList<Employe> findAll() {
        Query employees = em.createQuery("SELECT e FROM Employe e"
        );
        return new ArrayList<>(employees.getResultList());
    }

    @Override
    public void delete(Employe employe) {
        em.getTransaction().begin();
        em.remove(employe);
        em.getTransaction().commit();
    }

    @Override
    public Employe find(Long id) {
        return em.find(Employe.class, id);

    }
}
