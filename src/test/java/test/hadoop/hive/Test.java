package test.hadoop.hive;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

/**
 * @description 
 * @author lianglong
 */
public class Test {

	private static String driverName = "org.apache.hive.jdbc.HiveDriver";  
	  
    public boolean run() {  
  
        try {  
            Class.forName(driverName);  
            Connection con = null;  
            con = DriverManager.getConnection(  
                    "jdbc:hive2://192.168.10.107:10000/default", "root", "root");  
            Statement stmt = con.createStatement();  
            ResultSet res = null;  
  
            String sql = "select count(*) from t4";  
  
            System.out.println(new Date().toLocaleString() + sql);  
            res = stmt.executeQuery(sql);  
            while (res.next()) {  
                System.out.println(res.getString(1));  
            }  
            System.out.println(new Date().toLocaleString() + "ok");  
            return true;  
        } catch (Exception e) {  
            e.printStackTrace();  
            System.out.println("error");  
            return false;  
        }  
  
    }  
  
    public static void main(String[] args) throws SQLException {  
    	Test hiveJdbcClient = new Test();  
        hiveJdbcClient.run();  
    }  
	
}
