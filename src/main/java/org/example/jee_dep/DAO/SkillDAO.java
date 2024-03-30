package org.example.jee_dep.DAO;

import org.example.jee_dep.Model.Skill;

import java.util.ArrayList;

public interface SkillDAO {
    void save(Skill skill);

    Skill find(int id);

    public ArrayList<Skill> findAll();

    public void delete(Skill skill);
}
