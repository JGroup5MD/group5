import java.sql.*;

class Main1 {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try(Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5433/voting",
                "postgres", "postgres");
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT name, id FROM app.genres;");){
            while (resultSet.next()){
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");

                System.out.println(id + ": " + name);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}