package org.example.jee_dep.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import org.example.jee_dep.Model.Project;

import java.util.ArrayList;

public class ProjectDAOImpl implements ProjectDAO {
    EntityManagerFactory entityManagerFactory;
    EntityManager em;

    public ProjectDAOImpl() {
        entityManagerFactory = Persistence.createEntityManagerFactory("myPU");
        em = entityManagerFactory.createEntityManager();
    }

    @Override
    public void save(Project project) {
        em.getTransaction().begin();
        em.persist(project);
        em.getTransaction().commit();

    }

    @Override
    public ArrayList<Project> findAll() {
        Query projects = em.createQuery("SELECT e FROM Project e"
        );
        return new ArrayList<>(projects.getResultList());

    }

    @Override
    public void delete(Project project) {

    }

    @Override
    public Project find(int id) {
        return em.find(Project.class, id);

    }
}
