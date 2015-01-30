package com.ositran.model;

import java.io.Serializable;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * To create ID generator sequence "T_USER_ID_SEQ_GEN":
 * CREATE SEQUENCE "T_USER_ID_SEQ_GEN" INCREMENT BY 50 START WITH 50;
 */
@Entity
@NamedQueries({ @NamedQuery(name = "User.findAll", query = "select o from User o") })
@Table(name = "T_USER")
@SequenceGenerator(name = "User_Id_Seq_Gen", sequenceName = "T_USER_ID_SEQ_GEN", allocationSize = 50, initialValue = 50)
public class User implements Serializable {
    private static final long serialVersionUID = -5448469333990205146L;
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "User_Id_Seq_Gen")
    private BigDecimal id;
    @Column(length = 45)
    private String name;
    @Column(length = 45)
    private String surname;

    public User() {
    }

    public User(BigDecimal id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public BigDecimal getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
