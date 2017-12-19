package test.hadoop.hive;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @description 
 * @author lianglong
 */
public class HiveJdbcDemo {
	
	public static void main(String[] args) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "select * from t1";
		try {
			conn = HiveJdbcTest.getConnection();
			st = conn.createStatement();
			rs  = st.executeQuery(sql);
			while(rs.next()){
				String name = rs.getString(1);
				System.out.println(name);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HiveJdbcTest.release(conn, st, rs);
		}
		
	}

}
