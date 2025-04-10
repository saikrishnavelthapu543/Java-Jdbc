package jdbcpractice2;
import java.util.Scanner;
//jdbc by scanner input
public class test1 {
	public static void main(String[] args) {
		studentcontroller s=new studentcontroller();
		Scanner sc=new Scanner(System.in);
		System.out.println("please enter operataion :");
		String entervalue=sc.next();
		switch(entervalue)
		{
		case "save":
			studentpojo std= new studentpojo();
			System.out.println("please enter studentid :");
			std.setSid(sc.nextInt());
			System.out.println("please enter studentname :");
			std.setSname(sc.next());
			System.out.println("please enter studentage :");
			std.setAge(sc.nextInt());
			s.save(std);
			break;
		case "update":
			System.out.println("please enter studentname :");
			String name=sc.next();
			System.out.println("please enter studentid :");
			int id=sc.nextInt();
			s.update(name, id);
			break;
		case "delete":
			System.out.println("please enter studentid :");
			s.delete(sc.nextInt());
			break;
		case "getbyid":
			System.out.println("please enter studentid :");
			s.getbyid(sc.nextInt());
		break;
		case "getbyname":
			System.out.println("please enter studentname :");
			s.getbyname(sc.next());
			break;
		case "getall":
			s.getall();
		}
	}
}
