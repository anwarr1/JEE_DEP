package org.example.jee_dep.Controller;

import org.example.jee_dep.DAO.SkillDAOImpl;
import org.example.jee_dep.Model.Skill;
import org.example.jee_dep.Service.SkillService;

import java.util.ArrayList;

public class SkillController {
    ArrayList<String> skills;
    ArrayList<String> selectedSkills;

    public ArrayList<String> getSelectedSkills() {
        return selectedSkills;
    }

    public void setSelectedSkills(ArrayList<String> selectedSkills) {
        this.selectedSkills = selectedSkills;
    }

    SkillService skillService;
    SkillDAOImpl skillDAOImpl;
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SkillController() {

        this.skillDAOImpl = new SkillDAOImpl();
        this.skillService = new SkillService(skillDAOImpl);

    }

    public ArrayList<Skill> getSkills() {
        return skillService.findAll();
    }

    public void setSkills(ArrayList<String> skills) {
        this.skills = skills;
    }
}
