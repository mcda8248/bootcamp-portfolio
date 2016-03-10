package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseDAO {
	private static String url = "jdbc:mysql://localhost:3306/companydb";
	private static String user = "root";
	private static String password = "f0lue402";
	private ResultSet res = null;
	private ResultSetMetaData md = null;
	private Connection con = null;
	private Statement stt = null;
	private ArrayList<ArrayList<String>> results = new ArrayList<>();

	public ArrayList<ArrayList<String>> getQuery(String query) {
		try {
			results.clear();
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection(url, user, password);

			stt = con.createStatement();
			res = stt.executeQuery(query);

			md = res.getMetaData();
			
			while(res.next()) {
				ArrayList<String> temprow = new ArrayList<String>();
				for (int i = 1; (i < md.getColumnCount() + 1); i++) {
					temprow.add(res.getString(i));
				}
				results.add(temprow);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return results;
	}
	
	public int doUpdate(String query) {
		int uc = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection con = DriverManager.getConnection(url, user, password);

			Statement stt = con.createStatement();
			uc = stt.executeUpdate(query);
			con.close();
			stt.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return uc;
	}
}
