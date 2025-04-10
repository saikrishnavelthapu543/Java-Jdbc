package jdbcpractice2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
public class studentcontroller {
	//method to insert or save data into database
public void save(studentpojo std)
{	
	try {
		System.out.println("data saving to database");
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
		String squery="select * from employee.student";
		PreparedStatement p1=con.prepareStatement(squery);
		ResultSet rs=p1.executeQuery();
		ArrayList<Integer> list = new ArrayList<>();
		//Storing all id values in array list
		while(rs.next())
		{
			list.add(rs.getInt("sid"));	
		}
		//checking whether entered id matches elements in list
		//if no match found insert data will be proceeded
		if(list.contains(std.getSid()))
		{
			System.out.println("already id present");
			System.out.println("please enter correct id");
		}
		else
		{
			String uquery="insert into employee.student values(?,?,?)";
			PreparedStatement p=con.prepareStatement(uquery);
			p.setInt(1,std.getSid());
			p.setString(2,std.getSname());
			p.setInt(3,std.getAge());
			p.executeUpdate();
			System.out.println("saved");
			}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
//method to update database
public void update(String name,int id)
{
	try {
		System.out.println("data updating in database");
		Class.forName("Scom.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
		String uquery="update employee.student set sname=? where sid=?";
		PreparedStatement p=con.prepareStatement(uquery);
		p.setString(1,name);
		p.setInt(2,id);
		p.executeUpdate();
		System.out.println("updated");
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
//method to delete specified rows from database
public void delete(int id)
{
	try {
		System.out.println("data deleting from database");
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
		String uquery="delete from employee.student where sid=?";
		PreparedStatement p=con.prepareStatement(uquery);
		p.setInt(1,id);
		p.executeUpdate();
		System.out.println("deleted");
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
//method to extract data from database on the basis of student id
public void getbyid(int id)
{
	try {
		System.out.println("extracting from database");
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
		String squery="select * from employee.student where sid=?";
		PreparedStatement p=con.prepareStatement(squery);
		p.setInt(1, id);
		ResultSet rs=p.executeQuery();
		while(rs.next())
		{
			System.out.println(rs.getInt("sid")+","+rs.getString("sname")+","+rs.getInt("sage"));
		}
		System.out.println("extracted");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
//method to extract data from database on the basis of student name
public void getbyname(String name)
{
	try {
		System.out.println("extracting from database");
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
		String squery="select * from employee.student where sname=?";
		PreparedStatement p=con.prepareStatement(squery);
		p.setString(1, name);
		ResultSet rs=p.executeQuery();
		while(rs.next())
		{
			System.out.println(rs.getInt("sid")+","+rs.getString("sname")+","+rs.getInt("sage"));
		}
		System.out.println("extracted");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
//method to extract whole data from database
public void getall()
{
	try {
		System.out.println("extracting from database");
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
		String squery="select * from employee.student";
		PreparedStatement p=con.prepareStatement(squery);
		ResultSet rs=p.executeQuery();
		while(rs.next())
		{
			System.out.println(rs.getInt("sid")+","+rs.getString("sname")+","+rs.getInt("sage"));
		}
		System.out.println("extracted");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
//method used to get the values from database after inner join
public void innerjoin()
{
	try {
		System.out.println("extracting from database");
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
		String squery="select * from employee.student inner join employee.passport on sid=fksid";
		PreparedStatement p=con.prepareStatement(squery);
		ResultSet rs=p.executeQuery();
		while(rs.next())
		{
			System.out.println(rs.getString("sname")+","+rs.getString("pnum"));
		}
		System.out.println("extracted");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
//method used to get the values from database after lefts join
public void leftjoin()
{
	try {
		System.out.println("extracting from database");
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
		String squery="select * from employee.student left join employee.passport on sid=fksid";
		PreparedStatement p=con.prepareStatement(squery);
		ResultSet rs=p.executeQuery();
		while(rs.next())
		{
			System.out.println(rs.getInt("sid")+","+rs.getString("sname")+","+rs.getString("pnum"));
		}
		System.out.println("extracted");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
//method used to get the values from database after right join
public void rightjoin()
{
	try {
		System.out.println("extracting from database");
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
		String squery="select * from employee.student right join employee.passport on sid=fksid";
		PreparedStatement p=con.prepareStatement(squery);
		ResultSet rs=p.executeQuery();
		while(rs.next())
		{
			System.out.println(rs.getInt("sid")+","+rs.getString("sname")+","+rs.getInt("pid")+","+rs.getString("pnum"));
		}
		System.out.println("extracted");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
//getting the count of students
public void aggregatecount()
{
	try {
		System.out.println("extracting count of students database");
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
		String squery="select count(sid) as scount from employee.student";
		PreparedStatement p=con.prepareStatement(squery);
		ResultSet rs=p.executeQuery();
		while(rs.next())
		{
			System.out.println(rs.getInt("scount"));
		}
		System.out.println("extracted");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
//getting the max of students
public void aggregatemax()
{
	try {
		System.out.println("extracting maxcount of students database");
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
		String squery="select max(sid) as smax from employee.student";
		PreparedStatement p=con.prepareStatement(squery);
		ResultSet rs=p.executeQuery();
		while(rs.next())
		{
			System.out.println(rs.getInt("smax"));
		}
		System.out.println("extracted");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
//getting the min of students
public void aggregatemin()
{
	try {
		System.out.println("extracting mincount of students database");
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
		String squery="select min(sid) as smin from employee.student";
		PreparedStatement p=con.prepareStatement(squery);
		ResultSet rs=p.executeQuery();
		while(rs.next())
		{
			System.out.println(rs.getInt("smin"));
		}
		System.out.println("extracted");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
