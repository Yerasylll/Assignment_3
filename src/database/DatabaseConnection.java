package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBFunctions {
    public Connection connectToDB(String dbName, String user, String password) {
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbName, user, password);
            if(conn != null) {
                System.out.println("Connection Established!");
            }
            else {
                System.out.println("Connection Failed!");
            }

        } catch(Exception e) {
            System.out.println(e);
        }
        return conn;
    }
    public void createTable(Connection conn, String tableName) {
        Statement statement = null;
        try {
            String query = "create table " + tableName + "(donorID SERIAL, firstName varchar(100), lastName varchar(100), amount int, address varchar(100), charityName varchar(100), primary key(donorID));";
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table created!");
        } catch(Exception e) {
            System.out.println(e);
        }
    }
    public void insertRow(Connection conn, String tableName, String firstName, String lastName, int amount, String address, String charityName) {
        Statement statement = null;
        try {
            String query = String.format(
                    "INSERT INTO %s (firstName, lastName, amount, address, charityName) VALUES ('%s', '%s', %s, '%s', '%s');",
                    tableName, firstName, lastName, amount, address, charityName
            );
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Row inserted with Charity Name!");
        } catch(Exception e) {
            System.out.println(e);
        }
    }
    public void readData(Connection conn, String tableName) {
        Statement statement = null;
        ResultSet rs = null;
        try {
            String query = String.format("select * from %s", tableName);
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            while(rs.next()) {
                System.out.print(rs.getString("donorID") + " ");
                System.out.print(rs.getString("firstName") + " ");
                System.out.print(rs.getString("lastName") + " ");
                System.out.print(rs.getString("amount") + " ");
                System.out.println(rs.getString("address"));
            }
        } catch(Exception e) {
            System.out.println(e);
        }
    }
    public void updateAmountByDonorID(Connection conn, String tableName, int id, int amount) {
        Statement statement;
        try {
            String query = String.format("update %s set amount=%s, where donorID = %s", tableName, id, amount);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data updated!");
        } catch(Exception e) {
            System.out.println(e);
        }
    }
    public void searchByFirstName(Connection conn, String tableName, String firstName) {
        Statement statement;
        ResultSet rs = null;
        try {
            String query = String.format("select * from %s where firstName = '%s'", tableName, firstName);
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            while(rs.next()) {
                System.out.print(rs.getString("donorID") + " ");
                System.out.print(rs.getString("firstName")+ " ");
                System.out.print(rs.getString("lastName") + " ");
                System.out.println(rs.getString("address"));
            }
        } catch(Exception e) {
            System.out.println(e);
        }
    }
    public void searchByID(Connection conn, String tableName, int id) {
        Statement statement;
        ResultSet rs = null;
        try {
            String query = String.format("select * from %s where donorID = %s", tableName, id);
            statement = conn.createStatement();
            rs = statement.executeQuery(query);
            while(rs.next()) {
                System.out.print(rs.getString("donorID") + " ");
                System.out.print(rs.getString("firstName")+ " ");
                System.out.print(rs.getString("lastName") + " ");
                System.out.println(rs.getString("address"));
            }
        } catch(Exception e) {
            System.out.println(e);
        }
    }
    public void deleteRowByName(Connection conn, String tableName, String firstName) {
        Statement statement;
        try {
            String query = String.format("delete from %s where firstName = '%s'", tableName, firstName);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Row Deleted!");
        } catch(Exception e) {
            System.out.println(e);
        }
    }
    public void deleteRowByID(Connection conn, String tableName, int id) {
        Statement statement;
        try {
            String query = String.format("delete from %s where donorID = %s", tableName, id);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Row Deleted!");
        } catch(Exception e) {
            System.out.println(e);
        }
    }
    public void deleteTable(Connection conn, String tableName) {
        Statement statement;
        try {
            String query = String.format("drop table %s", tableName);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table Dropped!");
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
