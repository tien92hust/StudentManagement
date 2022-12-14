package ConnData;

import Model.Account;
import Model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConnJDBC {
    static String url = "jdbc:postgresql://localhost:5432/postgres";
    static String user = "postgres";
    static String password = "lhyieltgjtgy1";
    public static Connection getConnection(){
        Connection  connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
    public static List<Student> findAll(){
        List<Student> studentList = new ArrayList<>();
        String query = "select*from student";
        try {
            Connection connection = getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                Student st = new Student(rs.getInt("id"),
                                        rs.getString("name"),
                                        rs.getInt("age"),
                                        rs.getInt("gender"),
                                        rs.getString("major"),
                                        rs.getFloat("score"));
                studentList.add(st);
            }
        } catch (Exception e) {

        }
        return studentList;
    }

    public static void insert(Student st){
        String query = "insert into student (name, age, gender, major, score) values (?, ?, ?, ?, ?)";
        try {
            Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, st.getName());
            pstmt.setInt(2, st.getAge());
            pstmt.setInt(3, st.getGender());
            pstmt.setString(4, st.getMajor());
            pstmt.setFloat(5, st.getScore());
            pstmt.execute();
        } catch (Exception e) {

        }
    }

    public static void delete(Student st){
        String query = "delete from student where name = '"+st.getName()+"'";
        try {
            Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.executeUpdate();
        } catch (Exception e) {

        }
    }

    public static void Update(Student st){
        String query = "Update student set name=?, age=?, gender=?, major=?, score=? where name='"+st.getName()+"'";
        try {
            Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, st.getName());
            pstmt.setInt(2, st.getAge());
            pstmt.setInt(3, st.getGender());
            pstmt.setString(4, st.getMajor());
            pstmt.setFloat(5, st.getScore());
            pstmt.executeUpdate();
        } catch (Exception e) {

        }
    }

    public static List<Student>findByName(Student s){
        List<Student> studentl = new ArrayList<>();
        String query = "select*from student where student.name ='"+s.getName()+"'";
        try {
            Connection connection = getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                Student st = new Student(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getInt("gender"),
                        rs.getString("major"),
                        rs.getFloat("score"));
                studentl.add(st);
            }
        } catch (Exception e) {

        }
        return studentl;
    }

//    public static void getAccount(Account ac){
//        String queryUser = "select*from account where User=? and Password=?";
//        try {
//            Connection connection = getConnection();
//            PreparedStatement pstmt = connection.prepareCall(queryUser);
//            String us = String.valueOf(ac.getUser());
//            pstmt.setString(1,us);
//            pstmt.setString(2,ac.getPassword()) ;
//            ResultSet rs = pstmt.executeQuery();
//        } catch (Exception e) {
//        }
//    }
}
