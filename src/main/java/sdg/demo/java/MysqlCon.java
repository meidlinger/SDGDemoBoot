package sdg.demo.java;

import java.sql.*;

class MysqlCon {
	Connection con;
	private PreparedStatement preparedStatement = null;
	public MysqlCon() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");
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
}