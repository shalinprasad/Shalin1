package com.keane.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.keane.dbcon.ConnectionHolder;
import com.keane.dbcon.DBConnectionException;
import com.keane.dbfw.DBFWException;
import com.keane.dbfw.DBHelper;
import com.keane.dbfw.ParamMapper;
import com.keane.training.domain.Admin;
import com.keane.training.domain.Institute;



public class AdminDAO {
	static Logger log = Logger.getLogger(LoginDAO.class);

	public List validateUser(final int pid) throws DAOAppException {
		List res = null;
		ConnectionHolder ch = null;
		Connection con = null;
		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			ParamMapper paramMapper = new ParamMapper() {

				@Override
				public void mapParam(PreparedStatement pStmt)
						throws SQLException {
					pStmt.setInt(1, pid);
				}
			};
			res = DBHelper.executeSelect(con, SqlMapper.FETCH_USER,
					 SqlMapper.MAP_USER,paramMapper);

		} catch (DBConnectionException e) {
			log.error(e);
			throw new DAOAppException(e);
		} catch (DBFWException e) {
			throw new DAOAppException(e);
		}
		return res;

	}

	public static int InsertAdmin(final Admin a)
	{
		ConnectionHolder ch=null;
		Connection con=null;
		int result=0;
		
		try {
			ch=ConnectionHolder.getInstance();
			con=ch.getConnection();
			
			final ParamMapper INSERTADMIN=new ParamMapper()
			{

				
				public void mapParam(PreparedStatement preStmt)
						throws SQLException {
					preStmt.setInt(1, a.getAid());
					preStmt.setString(2, a.getAname());
					preStmt.setString(3, a.getApass());
					preStmt.setInt(4, a.getIid());
				
					
					
				}
			};

				
			
		result=DBHelper.executeUpdate(con,SqlMapper.INSERTADMIN,INSERTADMIN);
			
			
		} catch (DBFWException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DBConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
		
	}


	public static List LoginAdmin(final Admin a)
	{
		ConnectionHolder ch=null;
		Connection con=null;
		List result=null;
		
		try {
			ch=ConnectionHolder.getInstance();
			con=ch.getConnection();
			
			final ParamMapper LOGINADMIN=new ParamMapper()
			{

				
				public void mapParam(PreparedStatement preStmt)
						throws SQLException {
					preStmt.setInt(1,a.getAid());
					preStmt.setString(2,a.getApass());
				
					
					
				}
				
			};
			result=DBHelper.executeSelect(con,SqlMapper.LOGINADMIN,SqlMapper.ADMINEMAPPER1,LOGINADMIN);
		
			
			
		} catch (DBFWException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DBConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
		
	}


	public static int DeleteInstitute(final Institute i)
	{
		ConnectionHolder ch=null;
		Connection con=null;
		int result=0;
		
		try {
			ch=ConnectionHolder.getInstance();
			con=ch.getConnection();
			
			final ParamMapper DELETEINSTITUTE=new ParamMapper()
			{

				
				public void mapParam(PreparedStatement preStmt)
						throws SQLException {
					
					preStmt.setInt(1,i.getIid());	
					
				}	
			};
			
		result=DBHelper.executeUpdate(con,SqlMapper.DELETEINSTITUTE,DELETEINSTITUTE);
			
			
		} catch (DBFWException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DBConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
		
	}
	public static List StudentDetails12() throws DBFWException {
		ConnectionHolder ch=null;
		Connection con=null;
		List result=null;
		
		try {
			ch=ConnectionHolder.getInstance();
			con=ch.getConnection();
			
			final ParamMapper SDETAILS1=new ParamMapper()
			{
				public void mapParam(PreparedStatement preStmt)
				throws SQLException {
					
					//preStmt.setInt(1,iid);
					
					
				}
			};
				

			result=DBHelper.executeSelect(con,SqlMapper.STUDENTDETAILS13,SqlMapper.STUDENTDETAILS2,SDETAILS1);
					
				
				
		}
		 catch (DBConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
		// TODO Auto-generated method stub
		
	}
	public static List ViewInstitute() throws DBFWException {
		
	List result=null;
		ConnectionHolder ch=null;
		Connection con=null;
		
		
		try {
			ch=ConnectionHolder.getInstance();
			con=ch.getConnection();
			
			result=DBHelper.executeSelect(con,SqlMapper.VIEWINSTITUTE,SqlMapper.VIEWINSTITUTE1);
}
		catch (DBConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static int InsertStatus(final int iid,final int status)
	{
		ConnectionHolder ch=null;
		Connection con=null;
		int result=0;
		
		try {
			ch=ConnectionHolder.getInstance();
			con=ch.getConnection();
			
			final ParamMapper INSERTSTATUS=new ParamMapper()
			{

				
				public void mapParam(PreparedStatement preStmt)
						throws SQLException {
					preStmt.setInt(2,iid);	
					preStmt.setInt(1,status);	
					
				}	
			};
			
		result=DBHelper.executeUpdate(con,SqlMapper.INSERTSTATUS1,INSERTSTATUS);
			
			
		} catch (DBFWException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DBConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
}
	public static List ViewComplaints() throws DBFWException {
		ConnectionHolder ch=null;
		Connection con=null;
		List result=null;
		
		try {
			ch=ConnectionHolder.getInstance();
			con=ch.getConnection();
			
			result=DBHelper.executeSelect(con,SqlMapper.VIEWFEEDBACK,SqlMapper.VIEWFEEDBACK1);
							
		}
		 catch (DBConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
		// TODO Auto-generated method stub
		
	}
}