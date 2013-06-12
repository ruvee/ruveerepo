/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.mnote.jdb;
import java.sql.*;
import com.microsoft.sqlserver.jdbc.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Руслан
 */
public class MSSQLLogic {
    public Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    
    public boolean connect()
    {
        try {
            SQLServerDataSource ds = new SQLServerDataSource();
            ds.setUser("ucheckws");
            ds.setPassword("ucheckws");
            ds.setServerName("localhost");
            ds.setPortNumber(1433); 
            ds.setDatabaseName("ucheckws");
            connection = ds.getConnection();
            
            return true;
        } catch (SQLServerException ex) {
            Logger.getLogger(MSSQLLogic.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    };
    
    public static void executeStatement(Connection con) {
   try {
      String SQL = "SELECT LastName, FirstName FROM Person.Contact WHERE LastName = ?";
      PreparedStatement pstmt = con.prepareStatement(SQL);
      pstmt.setString(1, "Smith");
      ResultSet rs = pstmt.executeQuery();

      while (rs.next()) {
         System.out.println(rs.getString("LastName") + ", " + rs.getString("FirstName"));
      }
      rs.close();
      pstmt.close();
   }
   catch (Exception ex) {
     // ex.printStackTrace();
       Logger.getLogger(MSSQLLogic.class.getName()).log(Level.SEVERE, null, ex);
   }
  }
    
    
    public static void executeUpdateStatementCREATE(Connection con) {
   try {
      String SQL = "CREATE TABLE TestTable (Col1 int IDENTITY, Col2 varchar(50), Col3 int)";
      Statement stmt = con.createStatement();
      int count = stmt.executeUpdate(SQL);
      stmt.close();

      System.out.println("ROWS AFFECTED: " + count);
   }
   catch (Exception ex) {
     // ex.printStackTrace();
         Logger.getLogger(MSSQLLogic.class.getName()).log(Level.SEVERE, null, ex);
   }
}
    public Connection getConnection()
    {
        return connection;
    }
    
    public void executeUpdateStatement(String tablename, String columns, String values) {
        Connection con = getConnection();
   try {
      //String SQL = "INSERT INTO data (procs, val, prev, date) VALUES ('b',1,2,getdate())";
      String SQL = "INSERT INTO " + tablename + " (" + columns + ") VALUES (" + values + ")";
      Statement stmt = con.createStatement();
      int count = stmt.executeUpdate(SQL);
      System.out.println("ROWS AFFECTED: " + count);
      stmt.close();
   }
   catch (Exception ex) {
      // ex.printStackTrace();
         Logger.getLogger(MSSQLLogic.class.getName()).log(Level.SEVERE, null, ex);
   }
}

    
}
