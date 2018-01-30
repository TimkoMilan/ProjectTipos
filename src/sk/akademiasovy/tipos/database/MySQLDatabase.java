package sk.akademiasovy.tipos.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MySQLDatabase {
    private final String url = "jdbc:mysql://localhost:3306/";
    private final String dbName = "tipos";
    private final String driver = "com.mysql.jdbc.Driver";
    private final String username = "user2";
    private final String password = "heslo";
    private Connection conn ;

    public void testConnection() {
        try{
            Class.forName(driver).newInstance();
            conn= DriverManager.getConnection(url+dbName,username,password);
            if (conn == null) {
                System.out.println("Connection failed ");
            }
            else{
                System.out.println("Connection well");
            }
        }
        catch (Exception e){
            System.out.println("Error I cannot connect to the database");
        }
    }

    public boolean insertValuesIntoDrawHistory(int arr[]){
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url+dbName,username,password);
            String cmd = "INSERT INTO draw_history (ball1,ball2,ball3,ball4,ball5)";
            cmd+= "VALUES(?,?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(cmd);
            preparedStatement.setInt(1,arr[0]);
            preparedStatement.setInt(2,arr[1]);
            preparedStatement.setInt(3,arr[2]);
            preparedStatement.setInt(4,arr[3]);
            preparedStatement.setInt(5,arr[4]);
            preparedStatement.executeUpdate();
            conn.close();
        }

        catch (Exception e){
            System.out.println("Error  cannot connect to the database");
        }
        return true;
    }

}
