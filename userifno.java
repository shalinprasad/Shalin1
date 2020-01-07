import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class userifno {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","TRDB","TRDB");
		Statement stmt=con.createStatement();
		stmt.executeQuery("create table user_info(name varchar2(20)," +
				"employeeId number,technology varchar2(20)," +
				"password varchar2(20),portalid number)");

		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
