package jdbcpractice1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class basicconnection {
	public static void main(String[] args) {
		try {
			//for-name is used to load the class of my sql driver class in java
			Class.forName("com.mysql.cj.jdbc.Driver");
			//to get the connection with the database following statement is used
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
			//After connecting database a courier service is needed to transport from java-mysql and vice-versa
			//Statement,prepared statement,collable statement are used as courier services
			Statement s=con.createStatement();
			//to insert data query has been stored in string them the string is directed to execute with statement reference
			String insertq="update employee.registration set ename='saikrishna' where eid=1";
			int row=s.executeUpdate(insertq);
			System.out.println("no of rows effected"+row);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
