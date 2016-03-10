package data;

import java.sql.*;

public class test {
	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/";
		String user = "root";
		String password = "";
		System.out.println("rnning");
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection con = DriverManager.getConnection(url, user, password);

			Statement stt = con.createStatement();

			stt.execute("CREATE DATABASE IF NOT EXISTS test");
			stt.execute("USE test");

			stt.execute("DROP TABLE IF EXISTS people");
			stt.execute("CREATE TABLE people (" + "id BIGINT NOT NULL AUTO_INCREMENT," + "fname VARCHAR(25),"
					+ "lname VARCHAR(25)," + "PRIMARY KEY(id)" + ")");

			stt.execute("INSERT INTO people (fname, lname) VALUES"
					+ "('Joe', 'Bloggs'), ('Mary', 'Bloggs'), ('Jill', 'Hill')");

			ResultSet res = stt.executeQuery("SELECT * FROM people WHERE lname = 'Bloggs'");

			while (res.next()) {
				System.out.println(res.getString("fname") + " " + res.getString("lname"));
			}
			System.out.println("");

			PreparedStatement prep = con.prepareStatement("SELECT * FROM people WHERE lname = ?");
			prep.setString(1, "Bloggs");

			res = prep.executeQuery();
			while (res.next()) {
				System.out.println(res.getString("fname") + " " + res.getString("lname"));
			}

			res.close();
			stt.close();
			prep.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
