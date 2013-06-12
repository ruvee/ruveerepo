/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package ru.mnote.jdb;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

//import javax.naming.InitialContext;
//import javax.sql.DataSource;
/**
 *
 * @author dell
 */
public final class DbLogic {

    private String userName = "root";
    private String password = "";
    private String serverName = "localhost";
    private String portNumber = "3306";
    private String dbms = "mysql";
    private String dbName = "sch_hs";
    private String connect = "0";
    private String insert = "0";
    private String update = "0";
    private HashMap locales = null;
    private ArrayList localeNames;
    
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    

    public HashMap getLocales() {
        return locales;
    }

    public void setLocales(HashMap locales) {
        this.locales = locales;
    }

    public ArrayList getLocaleNames() {
        return localeNames;
    }

    public void setLocaleNames(ArrayList localeNames) {
        this.localeNames = localeNames;
    }

    public tableData[] getOrderList() {
        return orderList;
    }

    public void setOrderList(tableData[] orderList) {
        this.orderList = orderList;
    }
    
    /*
    private tableData[] orderList = new tableData[]{
        new tableData("A", "B", "C", "D", "E"),
        new tableData("F", "G", "H", "I", "J"),
        new tableData("A", "B", "C", "D", "E"),
        new tableData("F", "G", "H", "I", "J"),
        new tableData("A", "B", "C", "D", "E"),
        new tableData("F", "G", "H", "I", "J"),
        new tableData("A", "B", "C", "D", "E"),
        new tableData("F", "G", "H", "I", "J")
    };
*/
    
    public tableData[] orderList = new tableData[]{};
    public static class tableData {

        public String msg_id;
        public String ch_UID;
        public String msg_data;
        public String msg_date_recived;
        public String msg_date_sent;

        public tableData(String msg_id, String ch_UID, String msg_data, String msg_date_recived, String date_received) {
            this.msg_id = msg_id;
            this.ch_UID = ch_UID;
            this.msg_data = msg_data;
            this.msg_date_recived = msg_date_recived;
            this.msg_date_sent = date_received;
        }
        //getter and setter methods  

        public String getCh_UID() {
            return ch_UID;
        }
        public void setCh_UID(String ch_UID) {
            this.ch_UID = ch_UID;
        }
        public String getMsg_data() {
            return msg_data;
        }
        public void setMsg_data(String msg_data) {
            this.msg_data = msg_data;
        }
        public String getMsg_date_recived() {
            return msg_date_recived;
        }
        public void setMsg_date_recived(String msg_date_recived) {
            this.msg_date_recived = msg_date_recived;
        }
        public String getMsg_date_sent() {
            return msg_date_sent;
        }
        public void setMsg_date_sent(String msg_date_sent) {
            this.msg_date_sent = msg_date_sent;
        }
        public String getMsg_id() {
            return msg_id;
        }
        public void setMsg_id(String msg_id) {
            this.msg_id = msg_id;
        }
    }

    public String getInsert() {
        return insert;
    }

    public void setInsert(String insert) {
        this.insert = insert;
    }

    public void dbInsert() throws SQLException {

        Statement stmt = null;
        String query = this.insert;

        try {
            stmt = this.cc.createStatement();
            //stmt.executeUpdate(dbms);
            int rs = stmt.executeUpdate(query);
//            while (rs.next()) {
//                String coffeeName = rs.getString("msg_date_recived");
//                System.out.println(coffeeName);
//            }
        } catch (SQLException e) {
            //JDBCTutorialUtilities.printSQLException(e);
            String localizedMessage = e.getLocalizedMessage();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }

        this.insert = insert;
    }

    public String getUpdate() {
                getConnect();
        try {
            viewTable(cc, "sch_hs");
        } catch (SQLException ex) {
            Logger.getLogger(DbLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "";
    }

    public void setUpdate(String update) {
        this.update = update;
    }
    private Connection cc = null;

    public String getConnect() {
        try {
            this.cc = getConnection();
            //viewTable(cc,"sch_hs");
        } catch (SQLException ex) {
            Logger.getLogger(DbLogic.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }

        return connect;
    }

    public void setConnect(String connect) {
        this.connect = connect;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getDbms() {
        return dbms;
    }

    public void setDbms(String dbms) {
        this.dbms = dbms;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPortNumber() {
        return portNumber;
    }

    public void setPortNumber(String portNumber) {
        this.portNumber = portNumber;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public DbLogic() {
        //userName = null;
        //password = null;
        //serverName = null;
        //portNumber = null;
        //dbms = null;
        //dbName = null;
        this.locales = new HashMap();
        locales.put("msg_id", "1");
        locales.put("ch_UID", "2");
        locales.put("msg_data", "3");
        locales.put("msg_date_recived", "4");
        locales.put("date_received", "5");

        this.localeNames = new ArrayList();
        localeNames.add("msg_id");
        localeNames.add("ch_UID");
        localeNames.add("msg_data");
        localeNames.add("msg_date_recived");
        localeNames.add("date_received");
        
        


        // locales.put(cc, locales);
        LoadDriver();

    }

    public Connection getConnection() throws SQLException {

        Connection conn = null;
        Properties connectionProps = new Properties();
        connectionProps.put("user", this.userName);
        connectionProps.put("password", this.password);

        if (this.dbms.equals("mysql")) {
            conn = DriverManager.getConnection(
                    "jdbc:" + this.dbms + "://"
                    + this.serverName
                    + ":" + this.portNumber + "/" + this.dbName,
                    connectionProps);
        } else if (this.dbms.equals("derby")) {
            conn = DriverManager.getConnection(
                    "jdbc:" + this.dbms + ":"
                    + this.dbName
                    + ";create=true",
                    connectionProps);
        }

        System.out.println("Connected to database");
        return conn;
    }

    public void viewTable(Connection con, String dbName)
            throws SQLException {

        Statement stmt = null;
        String query = "select * from messages;";
        query = "CALL SelectMessagesForUser ( '" + this.name + "')" ;
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            tableData[] ts = null;
            
            this.orderList = ts;
            int i = 0;
            
            while (rs.next()) {
                i++;
            }
            rs.beforeFirst();
            ts = new tableData[i];
            this.orderList = ts;
            i=0;
            
            while (rs.next()) {
                String coffeeName = rs.getString("msg_date_recived");
                System.out.println(coffeeName); 

                String msg_id = rs.getString("msg_id");;
                String ch_UID = rs.getString("ch_UID");
                String msg_data = rs.getString("msg_data");
                String msg_date_recived = rs.getString("msg_date_recived");
                String msg_date_sent = rs.getString("msg_date_sent");
                
                ts[i] = new tableData(msg_id, ch_UID, msg_data, msg_date_recived, msg_date_sent);
                i++;
                
            }
             
        } catch (SQLException e) {
            //JDBCTutorialUtilities.printSQLException(e);
            String localizedMessage = e.getLocalizedMessage();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    public static void updateTable(Connection con, String dbName)
            throws SQLException {

        Statement stmt = null;
        String query = "select * from messages;";
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String coffeeName = rs.getString("msg_date_recived");
                System.out.println(coffeeName);
            }
        } catch (SQLException e) {
            //JDBCTutorialUtilities.printSQLException(e);
            String localizedMessage = e.getLocalizedMessage();
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

// Notice, do not import com.mysql.jdbc.*
// or you will have problems!
    private void LoadDriver() {
        try {
// The newInstance() call is a work around for some
// broken Java implementations
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
// handle the error
            ex = null;
        }
    }
}
