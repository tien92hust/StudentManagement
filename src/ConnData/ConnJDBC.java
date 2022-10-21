package ConnData;

import Model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConnJDBC {
    static String url = "jdbc:postgresql://localhost:5432/postgres";
    static String user = "postgres";
    static String password = "lhyieltgjtgy1";
    public static Connection getConnection(){
        System.out.println("Test cnn");
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
                                        rs.getString("password"),
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
        String query = "insert into student (password, name, age, gender, major, score) values (?, ?, ?, ?, ?, ?)";
        try {
            Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, st.getPassword());
            pstmt.setString(2, st.getName());
            pstmt.setInt(3, st.getAge());
            pstmt.setInt(4, st.getGender());
            pstmt.setString(5, st.getMajor());
            pstmt.setFloat(6, st.getScore());
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
        String query = "Update student set password=?, name=?, age=?, gender=?, major=?, score=? where name='"+st.getName()+"'";
        try {
            Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, st.getPassword());
            pstmt.setString(2, st.getName());
            pstmt.setInt(3, st.getAge());
            pstmt.setInt(4, st.getGender());
            pstmt.setString(5, st.getMajor());
            pstmt.setFloat(6, st.getScore());
            pstmt.executeUpdate();
        } catch (Exception e) {

        }
    }

    public static List<Student>findByName(Student s){
        List<Student> studentL = new ArrayList<>();
        String query = "select from student where name ='"+s.getName()+"' ";
        try {
            Connection connection = getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                Student st = new Student(rs.getInt("id"),
                        rs.getString("password"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getInt("gender"),
                        rs.getString("major"),
                        rs.getFloat("score"));
                studentL.add(st);
            }
        } catch (Exception e) {

        }
        return studentL;
    }
}
