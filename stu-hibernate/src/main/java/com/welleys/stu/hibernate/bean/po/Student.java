package com.welleys.stu.hibernate.bean.po;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@NamedNativeQuery(name = "all",query = "select * from student",resultClass = Student.class)
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String name;

    public Student() {
    }

    public Student(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
