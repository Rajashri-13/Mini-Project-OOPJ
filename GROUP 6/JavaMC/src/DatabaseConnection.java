/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author amand
 */
import java.sql.*;

class DatabaseConnection {
    private static final String DATABASE_URL = "jdbc:mysql://127.0.0.1/java";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "Vep4pta8xv";
    private static final String GET_LOGIN = "SELECT * FROM atten WHERE rollno = ?";
    static String attn = null;
    static String id = null;
    static String name = null;
    static String rollno = null;
    public Connection connectDatabase() {
        try {
            return DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
        } catch (SQLException e) {
            System.out.println("SQL Connection fail!");
        }
        return null;
    }
    public boolean getLogin(String x) throws SQLException {
        try (Connection connection = connectDatabase();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_LOGIN)) {
            preparedStatement.setString(1, x);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                this.attn = resultSet.getString("attendance");
                this.id = resultSet.getString("Id");
                this.name = resultSet.getString("name");
                this.rollno = x;
                return true;
            }
            else
                return false;
        }
    }
}
//