package org.example.jee_dep.Service;

import org.example.jee_dep.DAO.SkillDAOImpl;
import org.example.jee_dep.Model.Skill;

import java.util.ArrayList;

public class SkillService {
    SkillDAOImpl skillDAOImp;

    public SkillService(SkillDAOImpl skillDAOImp) {
        this.skillDAOImp = skillDAOImp;
    }

    public void save(Skill skill) {
        skillDAOImp.save(skill);
    }

    public ArrayList<Skill> findAll() {
        return skillDAOImp.findAll();
    }

    public void delete(int id) {

        skillDAOImp.delete(skillDAOImp.find(id));
    }
}
