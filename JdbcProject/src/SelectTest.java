import java.sql.DriverManager;
import java.sql.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.ResultSet;



public class SelectTest {

	public static void main(String[] args) {
		try {
		DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.4:1521:XE", "system", "pooja");
		
		System.out.println("Connected to database"+conn);
	  Statement statement=conn.createStatement();
	  System.out.println("Statement created:"+statement);
	  Scanner sc=new Scanner(System.in);
	  System.out.println("enter job");
	  String V_job=sc.nextLine();
	  
	  ResultSet rs=statement.executeQuery("select * from emp where job="+" '"+V_job+" '");
	  
	  Scanner scan2 = new Scanner(System.in);
      System.out.println("Enter starting date : ");
      String fromDate = scan2.nextLine();
     
      Scanner scan3 = new Scanner(System.in);
      System.out.println("Enter ending date   : ");
      String toDate = scan3.nextLine();
     
      //ResultSet dateRs = statement.executeQuery("select * from emp where hiredate between '01-Jan-81' and '31-Dec-81'");
      ResultSet dateRs = statement.executeQuery("select * from emp where hiredate between "+"'"+fromDate+"'"+" and "+"'"+toDate+"'");
     
	  
	  
	  
	  
	  
	  
	  while(rs.next()) {
		  System.out.println("emp number: "+rs.getInt(1));
		  System.out.println("emp name: "+rs.getString(2));
		  System.out.println("emp job: "+rs.getString(3));
		  
		  System.out.println("emp manager: "+rs.getString(4));
		  System.out.println("emp joining: "+rs.getString(5));
		  System.out.println("emp sal: "+rs.getInt(6));
		  System.out.println("emp comm: "+rs.getInt(7));
		  System.out.println("emp dept: "+rs.getInt(8));
		  System.out.println("----");
	  
	  }
	  rs.close();
	  statement.close();
	  System.out.println("closed");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*XE =
  (DESCRIPTION =
    (ADDRESS = (PROTOCOL = TCP)(HOST = 192.168.0.4)(PORT = 1521))
    (CONNECT_DATA =
      (SERVER = DEDICATED)
      (SERVICE_NAME = XE)
    )
  )*/
	
	
		}catch(SQLException e) {
			e.printStackTrace();
		}
		}

}
