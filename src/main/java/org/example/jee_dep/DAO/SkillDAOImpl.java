package org.example.jee_dep.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import org.example.jee_dep.Model.Skill;

import java.util.ArrayList;

public class SkillDAOImpl implements SkillDAO {
    EntityManagerFactory entityManagerFactory;
    EntityManager em;

    public SkillDAOImpl() {
        entityManagerFactory = Persistence.createEntityManagerFactory("myPU");
        em = entityManagerFactory.createEntityManager();
    }

    @Override
    public void save(Skill skill) {
        em.persist(skill);
    }

    @Override
    public ArrayList<Skill> findAll() {
        Query skills = em.createQuery("SELECT s FROM Skill s");
        return new ArrayList<>(skills.getResultList());

    }

    @Override
    public void delete(Skill skill) {
        em.getTransaction().begin();
        em.remove(skill);
        em.getTransaction().commit();

    }

    @Override
    public Skill find(int id) {
        return em.find(Skill.class, id);
    }
}
