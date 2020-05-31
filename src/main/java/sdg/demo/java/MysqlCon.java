package sdg.demo.java;

import java.sql.*;
import java.util.ArrayList;

class MysqlCon {
	Connection con;
	private PreparedStatement preparedStatement = null;
	public MysqlCon() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String host = System.getenv("MYSQL_SERVICE_HOST");
			String port = System.getenv("MYSQL_SERVICE_PORT_MYSQL");
			con = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/employee", "root", "root");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public String searchEmpTitle(String name) {
		try {
			preparedStatement = con.prepareStatement("select * from emp where emp.name= ?");
			preparedStatement.setString(1, name);        
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next())
				return rs.getString(3);
			return "Not Exist";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	public String[] getAllTitles() {
		ArrayList<String> titles = new ArrayList<String>();
		try {
			preparedStatement = con.prepareStatement("select title from emp");       
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				titles.add(rs.getString(1));
			}
			return (String[]) titles.toArray();
		} catch (Exception e) {
			titles.add("error:" + e.getMessage());
			return (String[]) titles.toArray();
		}
	}
}