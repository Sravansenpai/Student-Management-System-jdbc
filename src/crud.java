
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class crud {

    public void addStudent(Student s) {
        String sql = "INSERT INTO students (name, age, grade) VALUES (?, ?, ?)";
        try (Connection conn = jdbccon.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, s.getName());
            stmt.setInt(2, s.getAge());
            stmt.setString(3, s.getGrade());
            stmt.executeUpdate();
            System.out.println("Student added successfully!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try (Connection conn = jdbccon.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Student s = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("grade")
                );
                list.add(s);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public void updateStudent(int id, String name, int age, String grade) {
        String sql = "UPDATE students SET name=?, age=?, grade=? WHERE id=?";
        try (Connection conn = jdbccon.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setInt(2, age);
            stmt.setString(3, grade);
            stmt.setInt(4, id);
            int rows = stmt.executeUpdate();
            if (rows > 0)
                System.out.println("Student updated successfully!");
            else
                System.out.println("No student found with ID: " + id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteStudent(int id) {
        String sql = "DELETE FROM students WHERE id=?";
        try (Connection conn = jdbccon.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            if (rows > 0)
                System.out.println("Student deleted successfully!");
            else
                System.out.println(" No student found with ID: " + id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}


