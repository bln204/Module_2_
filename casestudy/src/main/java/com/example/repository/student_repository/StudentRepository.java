package com.example.repository.student_repository;

import com.example.model.Student;
import com.example.repository.BaseRepository;

import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository {

    private BaseRepository baseRepository;
    {
        try {
            baseRepository = new BaseRepository();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static final String Get_id_student = "SELECT * FROM student\n" + " WHERE id =?;";

    private static final String FIND_ALL = "SELECT * FROM student";

    private static final String INSERT_STUDENT =
            "INSERT INTO student(name, email, gender, point)" + "VALUES(?,?,?,?)";

    @Override
    public List<Student> findAll() {
        Connection connection = baseRepository.getConnection();
        List<Student> list = new ArrayList<>();
        try{
            java.sql.Statement statement = connection.createStatement();
            java.sql.ResultSet resultSet = statement.executeQuery(FIND_ALL);
            while (resultSet.next()){
                int id = resultSet.getInt("id_student");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                int gender = resultSet.getInt("gender");
                int point = resultSet.getInt("point");
                list.add(new Student(id, name, email, gender, point));
            }
        } catch (SQLException e){
            System.err.println(e.getMessage());
        }
        return list;
    }

    @Override
    public List<Student> getStudentById(int id) {
        Connection connection = baseRepository.getConnection();
        List<Student> list = new ArrayList<>();
        try{
            PreparedStatement ps = connection.prepareStatement(Get_id_student);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                int studentId = resultSet.getInt("id_student");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                int gender = resultSet.getInt("gender");
                int point = resultSet.getInt("point");
                list.add(new Student(studentId, name, email, gender, point));
            }
        } catch(SQLException e){
            System.err.println(e.getMessage());
        }
        return list;
    }

    @Override
    public void addNewStudent(Student student) {
        Connection connection = baseRepository.getConnection();
        try{
            PreparedStatement ps = connection.prepareStatement("INSERT_STUDENT");
            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setInt(3, student.getGender());
            ps.setInt(4, student.getPoint());
            ps.executeUpdate();
        } catch(SQLException e){
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void save(Student student) {

    }

    @Override
    public void deleteStudent(int id) {

    }
}
