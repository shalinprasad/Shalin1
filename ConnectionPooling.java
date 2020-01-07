import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;


public class ConnectionPooling {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Connection con=null;
		try {
			con=getConnection();
			System.out.println("connected");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

	}//main
	
	public static Connection getConnection() throws SQLException, FileNotFoundException, IOException
	{
		BasicDataSource bds=null;
		synchronized(BasicDataSource.class){
			if(bds==null)
			{
				Properties p=new Properties();
				p.load(new FileInputStream("jdbcds.properties"));
				bds=new BasicDataSource();
				String uid=p.getProperty("uid");
				String pwd=	p.getProperty("pwd");
				bds.setDriverClassName(p.getProperty("driver"));
				bds.setUrl(p.getProperty("url"));
				bds.setUsername(uid);
				bds.setPassword(pwd);
			
			}
			
		}
		return bds.getConnection();
		
		
		
	
		
		
		
		
		
	}

}
