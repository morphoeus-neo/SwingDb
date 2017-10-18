/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.aurelien.swingDB.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import fr.aurelien.swingDB.entity.Student;

/**
 *
 * @author formation
 */
public class StudentDAO implements DAOInterface<Student, StudentDAO> {

    private Connection dbConnection;
    private PreparedStatement pstm;
    private ResultSet resultSet;

    public StudentDAO(Connection dbConnection) {
        this.dbConnection = dbConnection;

    }

    // un objet de type Student
    /**
     * Persistance de l'entité Student
     *
     * @param entity
     * @return
     * @throws java.sql.SQLException
     */
    @Override
    public int save(Student entity) throws SQLException {
        int affectedRows;
        if (entity.getId() == null) {
            //insertion
            affectedRows = this.insert(entity);
        } else {
            //mise a jour
            affectedRows = this.update(entity);
        }
        return 1;
    }

    /**
     *
     * @param entity
     * @return
     * @throws SQLException
     */
    private int insert(Student entity) throws SQLException {
        String sql = "INSERT INTO students ( name, firstName, sexe) VALUES (?,?,?)";

        pstm = dbConnection.prepareStatement(sql);
        pstm.setString(1, entity.getName());
        pstm.setString(2, entity.getFirstName());
        pstm.setString(3, String.valueOf(entity.getSexe()));
        return pstm.executeUpdate();
    }

    /**
     *
     * @param entity
     * @return
     * @throws SQLException
     */
    private int update(Student entity) throws SQLException {

        String sql = "UPDATE students SET name=?, firstname=?, sexe=? WHERE id = ?";

        pstm = dbConnection.prepareStatement(sql);
        pstm.setString(1, entity.getName());
        pstm.setString(2, entity.getFirstName());
        pstm.setString(3, String.valueOf(entity.getSexe()));
        pstm.setInt(4, entity.getId());

        return pstm.executeUpdate();
    }

    @Override
    public void deleteOneById(Student entity) throws SQLException {
        if (entity.getId() != null) {
            String sql = "DELETE FROM students WHERE id=?";
            pstm = dbConnection.prepareStatement(sql);
            pstm.setInt(1, entity.getId());
            pstm.executeUpdate();
        }
    }


    public StudentDAO findOneById(int id) throws SQLException {
        String sql = "SELECT * FROM students WHERE id=?";
        pstm = dbConnection.prepareStatement(sql);
        pstm.setInt(1,id);
        pstm.executeUpdate();
        return this;
    }

    /**
     * Récupération d'une ligne de la table
     * @return
     * @throws SQLException 
     */
    public Student getOne() throws SQLException {
        Student entity = new Student();
        if (resultSet.next()) {
            entity.setName(resultSet.getString("name"));
            entity.setFirstName(resultSet.getString("firstName"));
            entity.setSexe(resultSet.getString("sexe").charAt(0));

        }
        return entity;
    }
    
    
    /**
     * Récupération des rsultats d'ne requette sous la forme d'un tableau assiocatif
     * @return
     * @throws SQLException 
     */
    public Map<String, String> getOneAsMap() throws SQLException{
        Map<String, String> studentData = new HashMap<>();
        if (resultSet.next()) {
            studentData.put("name", resultSet.getString("name"));
            studentData.put("firstName", resultSet.getString("firstName"));
            studentData.put("sexe", resultSet.getString("sexe")); 
        }

        return studentData;
    }
    
    
       public StudentDAO findAll() throws SQLException {
        String sql = "SELECT * FROM students ";
        pstm = dbConnection.prepareStatement(sql);

        resultSet = pstm.executeQuery();
        return this;
    }

public List<Student> getAll() throws SQLException{
    List<Student> studentList = new ArrayList<>();
    
    while (resultSet.isBeforeFirst()) {
        studentList.add(this.getOne());
        
    }
    return studentList;
}

public List<Map<String, String>> getAllAsArray() throws SQLException{
     List<Map<String, String>> studentList = new ArrayList<>();
    while (resultSet.isBeforeFirst()) {
        studentList.add(this.getOneAsMap());
        
        
    }
    
    return studentList;
}


}
