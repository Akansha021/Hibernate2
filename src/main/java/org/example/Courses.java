package org.example;

import jakarta.persistence.*;

@Entity
@Table(name = "COURSES")
public class Courses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    ,generator = "gen" (Sequence Strategy)
//    @SequenceGenerator(name = "gen",sequenceName = "seqgen",allocationSize = 1)
    int id;
    String name;


    @ManyToOne(cascade = CascadeType.ALL)
//            (targetEntity = NamedQuery.class)
    @JoinColumn(name="sid")
    NamedQuery1 NamedQuery=new NamedQuery1();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NamedQuery1 getNamedQuery() {
        return NamedQuery;
    }

    public void setNamedQuery(NamedQuery1 NamedQuery) {
        this.NamedQuery = NamedQuery;
    }

    @Override
    public String toString() {
        return "Courses{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", NamedQuery=" + NamedQuery +
                '}';
    }
}
