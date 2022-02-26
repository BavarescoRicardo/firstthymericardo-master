package com.thymspringricard.firstthymericardo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Usuario 
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nomelogin;
    private String senhalogin;
    private int permit;

    public Usuario()
    {

    }

    public Usuario(Long id, String nomelogin, String senhalogin, int permit)
    {
        this.id = id;
        this.nomelogin = nomelogin;
        this.senhalogin = senhalogin;
        this.permit = permit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPermit() {
        return permit;
    }

    public void setPermit(int permit) {
        this.permit = permit;
    }

    public String getSenhalogin() {
        return senhalogin;
    }

    public void setSenhalogin(String senhalogin) {
        this.senhalogin = senhalogin;
    }

    public String getNomelogin() {
        return nomelogin;
    }

    public void setNomelogin(String nomelogin) {
        this.nomelogin = nomelogin;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return getNomelogin() +  " - " + getSenhalogin();
    }
}
