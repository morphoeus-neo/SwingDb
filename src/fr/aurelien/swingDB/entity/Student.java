/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.aurelien.swingDB.entity;

/**
 * Creation d'un DTO
 *
 * @author formation
 */
public class Student {

    private Integer id;
    private String name;
    private String firstName;
    private char sexe;

    //constructeur Vide
    public Student() {
    }

    //constructeur avec tous les parametres
    public Student(String name, String firstName, char sexe) {
        this.name = name;
        this.firstName = firstName;
        this.sexe = sexe;
    }
// Génération des getteurs et setteurs avec " alt+inser "

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public char getSexe() {
        return sexe;
    }

    public void setSexe(char sexe) {
        this.sexe = sexe;
    }

    public String getCivilite() {
        String civilite = "";
        switch (this.sexe) {
            case 'F':
                civilite = "madame";
                break;
            case 'M':
                civilite = "monsieur";
                break;
            default:
                civilite = "truc";
                break;
        }
        ;
        return civilite;
    }

    public void greet() {
        StringBuilder sb = new StringBuilder();
        sb.append("Bonjour ");
        sb.append(this.getCivilite());
        sb.append(" ");
        sb.append(this.name);
        sb.append(" ");
        sb.append(this.firstName);

        System.out.println(sb.toString());

    }

}
