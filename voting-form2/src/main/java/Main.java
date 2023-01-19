import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.*;

class Main1 {
    public static void main(String[] args) {
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        try {
            cpds.setDriverClass( "org.postgresql.Driver" ); //loads the jdbc driver
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }
            cpds.setJdbcUrl( "jdbc:postgresql://localhost:5433/voting" );
            cpds.setUser("postgres");
            cpds.setPassword("postgres");


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