package org.example.jee_dep.Model;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name = "skills")
public class Skill {

    @Column(name = "name")
    String name;

  @ManyToMany(mappedBy = "skills")

    ArrayList<Employe> employes;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public ArrayList<Employe> getEmployes() {
        return employes;
    }

    public void setEmployes(ArrayList<Employe> employes) {
        this.employes = employes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
