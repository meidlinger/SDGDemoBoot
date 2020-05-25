package sdg.demo.java;


public class Employee {
	private String employeeName;
	private String employeeTitle;
	private String employeeID;
	MysqlCon myconn;
	public Employee() {
		myconn = new MysqlCon();
	}
	
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeTitle() {
		return employeeTitle;
	}
	public void setEmployeeTitle(String employeeTitle) {
		this.employeeTitle = employeeTitle;
	}
	public String getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}
	
	public String searchTitleByName(String name) {
		return myconn.searchEmpTitle(name);
	}

}
