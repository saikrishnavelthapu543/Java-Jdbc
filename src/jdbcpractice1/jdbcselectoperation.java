package jdbcpractice1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class jdbcselectoperation {
public static void main(String[] args) {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
		//query to return rows should be Stored in a String
		String squry="select * from employee.registration";
		//to retrieve data we can use prepared statement courier service
		PreparedStatement p=con.prepareStatement(squry);
		//returns Result set
		//It is an interface
		ResultSet row=p.executeQuery();
		//Extracting data from database using while loop
		while(row.next())
		{
			int id=row.getInt(1);
			String name=row.getString(2);
			int age=row.getInt(3);
			System.out.println(id+","+name+","+age);
		}
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
