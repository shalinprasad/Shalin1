package com.keane.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.keane.dbcon.ConnectionHolder;
import com.keane.dbcon.DBConnectionException;
import com.keane.dbfw.DBFWException;
import com.keane.dbfw.DBHelper;
import com.keane.dbfw.ParamMapper;
import com.keane.training.domain.Article;
import com.keane.training.domain.Faculty;
import com.keane.training.domain.Institute;
import com.keane.training.domain.Request;

public class InstituteDAO {
	public static int InsertInstitute(final Institute i)
	{
		ConnectionHolder ch=null;
		Connection con=null;
		int result=0;
		
		try {
			ch=ConnectionHolder.getInstance();
			con=ch.getConnection();
			
			final ParamMapper INSERTINSTITUTE=new ParamMapper()
			{

				
				public void mapParam(PreparedStatement preStmt)
						throws SQLException {
					preStmt.setInt(1, i.getIid());
					preStmt.setString(2,i.getIname());
					preStmt.setString(3,i.getAffdate());
					preStmt.setString(4,i.getIaddr());
					preStmt.setInt(5,i.getIseats());
					preStmt.setInt(6,i.getIcourse());
					preStmt.setString(7,i.getIpass());
				    preStmt.setInt(8,i.getStatus());
//					preStmt.setInt(9,s.getIid());
//					
					
				}
				
			};
			
		result=DBHelper.executeUpdate(con,SqlMapper.INSERTINSTITUTE,INSERTINSTITUTE);
			
			
		} catch (DBFWException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DBConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
		
	}


	public static List LoginInstitute(final Institute i) {
		ConnectionHolder ch=null;
		Connection con=null;
		List result=null;
		
		try {
			ch=ConnectionHolder.getInstance();
			con=ch.getConnection();
			final ParamMapper LOGININSTITUTE=new ParamMapper()
			{
				public void mapParam(PreparedStatement preStmt)
				throws SQLException {
					preStmt.setString(1,i.getIname());
					preStmt.setString(2,i.getIpass());
				}
			};
				
				result=DBHelper.executeSelect(con,SqlMapper.LOGININSTITUTE,SqlMapper.INSTITUTEMAPPER1,LOGININSTITUTE);
		}
		 catch (DBFWException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DBConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
		// TODO Auto-generated method stub
		
	}
	public static int UpdateInstitute(final Institute i) {
		ConnectionHolder ch=null;
		Connection con=null;
		int result=0;
		
		try {
			ch=ConnectionHolder.getInstance();
			con=ch.getConnection();
			final ParamMapper UPDATEINSTITUTE=new ParamMapper()
			{
				public void mapParam(PreparedStatement preStmt)
				throws SQLException {
					preStmt.setInt(1,i.getIid());
					preStmt.setString(2,i.getAffdate());
					preStmt.setString(3,i.getIaddr());
					preStmt.setInt(4,i.getIseats());
					preStmt.setInt(5,i.getIcourse());
					preStmt.setString(6,i.getIpass());
					preStmt.setString(7,i.getIname());
					
				}
			};
				result=DBHelper.executeUpdate(con,SqlMapper.UPDATEINSTITUTE,UPDATEINSTITUTE);
		}
		 catch (DBFWException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DBConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
		// TODO Auto-generated method stub
		
	}
	public static int FacultyInfo(final Faculty f) {
		ConnectionHolder ch=null;
		Connection con=null;
		int result=0;
		
		try {
			ch=ConnectionHolder.getInstance();
			con=ch.getConnection();
			final ParamMapper FACULTYINFO=new ParamMapper()
			{
				public void mapParam(PreparedStatement preStmt)
				throws SQLException {
					preStmt.setInt(1,f.getFid());
					preStmt.setString(2,f.getFname());
					preStmt.setString(3,f.getDept());
					preStmt.setInt(4,f.getIid());
					
				}
			};
				result=DBHelper.executeUpdate(con,SqlMapper.FACULTYINFO,FACULTYINFO);
		}
		 catch (DBFWException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DBConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
		// TODO Auto-generated method stub
		
	}
	public static List StudentDetails(final int iid) throws DBFWException {
		ConnectionHolder ch=null;
		Connection con=null;
		List result=null;
		
		try {
			ch=ConnectionHolder.getInstance();
			con=ch.getConnection();
			
			final ParamMapper SDETAILS=new ParamMapper()
			{
				public void mapParam(PreparedStatement preStmt)
				throws SQLException {
					preStmt.setInt(1,iid);
					
					
				}
			};
				

			result=DBHelper.executeSelect(con,SqlMapper.STUDENTDETAILS,SqlMapper.STUDENTDETAILS1,SDETAILS);
					
				
				
		}
		 catch (DBConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
		// TODO Auto-generated method stub
		
	}
	public static List ViewRequests(final int iid) throws DBFWException {
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
					preStmt.setInt(1,iid);
					
					
				}
			};
			result=DBHelper.executeSelect(con,SqlMapper.VIEWREQUESTS1,SqlMapper.VIEWREQUESTS,SDETAILS1);
							
		}
		 catch (DBConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
		// TODO Auto-generated method stub
		
	}
	public static int InsertResponse(final Request r) {
		ConnectionHolder ch=null;
		Connection con=null;
		int result=0;
		
		try {
			ch=ConnectionHolder.getInstance();
			con=ch.getConnection();
			final ParamMapper RESPONSEINFO=new ParamMapper()
			{
				public void mapParam(PreparedStatement preStmt)
				throws SQLException {
					preStmt.setInt(1, r.getIid());
					preStmt.setInt(2,r.getSid());
					preStmt.setString(3,r.getRes());
					
					
				}
			};
				result=DBHelper.executeUpdate(con,SqlMapper.INSERTRESPONSE1,RESPONSEINFO);
		}
		 catch (DBFWException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DBConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
		// TODO Auto-generated method stub
		
	}
	public static List ViewFeedback(final int iid) throws DBFWException {
		ConnectionHolder ch=null;
		Connection con=null;
		List result=null;
		
		try {
			ch=ConnectionHolder.getInstance();
			con=ch.getConnection();
			
			final ParamMapper VFEEDBACK=new ParamMapper()
			{
				public void mapParam(PreparedStatement preStmt)
				throws SQLException {
					preStmt.setInt(1,iid);
					
					
				}
			};
				

			result=DBHelper.executeSelect(con,SqlMapper.VIEWFEEDBACK,SqlMapper.VIEWFEEDBACK1,VFEEDBACK);
					
				
				
			
		}
		 catch (DBConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
		// TODO Auto-generated method stub
		
	}
	public static int UpdateArticle(final Article a) {
		ConnectionHolder ch=null;
		Connection con=null;
		int result=0;
		
		try {
			ch=ConnectionHolder.getInstance();
			con=ch.getConnection();
			final ParamMapper ARTICLE=new ParamMapper()
			{
				public void mapParam(PreparedStatement preStmt)
				throws SQLException {
					preStmt.setInt(1,a.getAid());
					preStmt.setInt(2,a.getIid());
					preStmt.setString(3,a.getArticle());
					
					
				}
			};
				result=DBHelper.executeUpdate(con,SqlMapper.UPLOADARTICLE1,ARTICLE);
		}
		 catch (DBFWException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DBConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
		// TODO Auto-generated method stub
	}
	
}






