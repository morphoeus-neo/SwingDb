/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.aurelien.swingDB.entity;

/**
 *
 * @author formation
 */
public class User {
    private int id;
    private String name;
    private String firstName;
    private String email;
    private String password;
    private String role;
    
    
    public User() {
    }

    
    
    
    public User(int id, String name, String firstName, String email, String password, String role) {
        this.id = id;
        this.name = name;
        this.firstName = firstName;
        this.email = email;
        this.password = password;
        this.role = role;
    }

public int getId() {
        return id;
    }

    public User setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getRole() {
        return role;
    }

    public User setRole(String role) {
        this.role = role;
        return this;
    }
    
}
