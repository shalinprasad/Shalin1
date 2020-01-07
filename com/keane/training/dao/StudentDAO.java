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
import com.keane.training.domain.Feedback;
import com.keane.training.domain.Request;
import com.keane.training.domain.Student;




public class StudentDAO {
	private static final ParamMapper ComplaintStudent = null;
	private static ParamMapper INSERTFEEDBACK1;

	public static int insertStudent(final Student s)
	{
		ConnectionHolder ch=null;
		Connection con=null;
		int result=0;
		
		try {
			ch=ConnectionHolder.getInstance();
			con=ch.getConnection();
			
			final ParamMapper INSERTSTUDENT=new ParamMapper()
			{

				
				public void mapParam(PreparedStatement preStmt)
						throws SQLException {
					preStmt.setInt(1, s.getSid());
					preStmt.setString(2,s.getSname());
					preStmt.setString(3,s.getSqual());
					preStmt.setString(4,s.getContact());
					preStmt.setString(5,s.getSaddr());
					preStmt.setString(6,s.getSemail());
					preStmt.setString(7,s.getSpass());
				    preStmt.setInt(8,s.getIid());
//					
					
				}
				
			};
			
		result=DBHelper.executeUpdate(con,SqlMapper.INSERTSTUDENT,INSERTSTUDENT);
			
			
		} catch (DBFWException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DBConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
		
	}
	public boolean validateUser(final int Studentid) throws DAOAppException {
		ConnectionHolder ch = null;
		Connection con = null;
		List users = null;

		ParamMapper paramMapper = new ParamMapper() {

			@Override
			public void mapParam(PreparedStatement pStmt) throws SQLException {
				pStmt.setInt(1, Studentid);
			}
		};
		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			users = DBHelper.executeSelect(con, SqlMapper.FETCH_USER,
					 SqlMapper.MAP_USER,paramMapper);

		} catch (DBConnectionException e) {
			throw new DAOAppException(e);
		} catch (DBFWException e) {
			throw new DAOAppException(e);
		}

		return (users != null && users.size() > 0);

	}

	public static List LoginStudent(final Student s) {
		ConnectionHolder ch=null;
		Connection con=null;
	List result=null;
		
		try {
			ch=ConnectionHolder.getInstance();
			con=ch.getConnection();
			
			final ParamMapper LOGINSTUDENT=new ParamMapper()
			{
				public void mapParam(PreparedStatement preStmt)
				throws SQLException {
					preStmt.setInt(1, s.getSid());
					preStmt.setString(2,s.getSpass());
				}
			};
		// TODO Auto-generated method stub
result=DBHelper.executeSelect(con,SqlMapper.LOGINSTUDENT,SqlMapper.STUDENTEMAPPER1,LOGINSTUDENT);
			
			
		} catch (DBFWException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DBConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	public static int UpdateStudent(final Student s) {
		{
			ConnectionHolder ch=null;
			Connection con=null;
			int result=0;
			
			try {
				ch=ConnectionHolder.getInstance();
				con=ch.getConnection();
				
				final ParamMapper UpdateStudent=new ParamMapper()
				{

					
					public void mapParam(PreparedStatement preStmt)
							throws SQLException {
						
						preStmt.setString(1,s.getSname());
						preStmt.setString(2,s.getSqual());
						preStmt.setString(3,s.getContact());
						preStmt.setString(4,s.getSaddr());
						preStmt.setString(5,s.getSemail());
						preStmt.setString(6,s.getSpass());
						preStmt.setInt(7,s.getSid());
						//preStmt.setInt(7,iid);
						
						
						
//						preStmt.setInt(8,s.getStatus());
//						preStmt.setInt(9,s.getIid());
//						
						
					}
					
				};
				
				result=DBHelper.executeUpdate(con,SqlMapper.UPDATESTUDENT,UpdateStudent);
					
					
				} catch (DBFWException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (DBConnectionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return result;
				
				
			}
		// TODO Auto-generated method stub
		
	}

	public static int ComplaintStudent(final Request r ) {
		ConnectionHolder ch=null;
		Connection con=null;
		int result=0;
		
		try {
			ch=ConnectionHolder.getInstance();
			con=ch.getConnection();
			
			final ParamMapper ComplaintStudent=new ParamMapper()
			{
				
				public void mapParam(PreparedStatement preStmt)
						throws SQLException {
					
					preStmt.setInt(1,r.getCid());
					preStmt.setInt(2,r.getSid());
					preStmt.setInt(3,r.getIid());
					preStmt.setString(4,r.getComplaint());
		// TODO Auto-generated method stub
					
				}
				
			};
			
			result=DBHelper.executeUpdate(con,SqlMapper.COMPLAINTSTUDENT,ComplaintStudent);
				
				
			} catch (DBFWException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DBConnectionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return result;
			
			
		}
	// TODO Auto-generated method stub
	public static List ViewResponse(final int iid,final int sid1) throws DBFWException {
		ConnectionHolder ch=null;
		Connection con=null;
		List result=null;
		
		try {
			ch=ConnectionHolder.getInstance();
			con=ch.getConnection();
			
			final ParamMapper RESPONSE=new ParamMapper()
			{
				public void mapParam(PreparedStatement preStmt)
				throws SQLException {
					preStmt.setInt(1,iid);
					preStmt.setInt(2,sid1);
					
					
					
				}
			};
			result=DBHelper.executeSelect(con,SqlMapper.VIEWRESPONSE1,SqlMapper.VIEWRESPONSE,RESPONSE);
							
		}
		 catch (DBConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
		// TODO Auto-generated method stub
		
	}
	public static int InsertFeedback(final Feedback f) {
		ConnectionHolder ch=null;
		Connection con=null;
		int result=0;
		
		try {
			ch=ConnectionHolder.getInstance();
			con=ch.getConnection();
			
			final ParamMapper InsertRequest=new ParamMapper()
			{
				
				public void mapParam(PreparedStatement preStmt)
						throws SQLException {
					
					preStmt.setInt(1,f.getCid());
					preStmt.setInt(2,f.getSid());
					preStmt.setInt(3,f.getIid());
					preStmt.setString(4,f.getFeedback());
		// TODO Auto-generated method stub
					
				}
				
			};
			
			result=DBHelper.executeUpdate(con,SqlMapper.INSERTFEEDBACK,InsertRequest);
				
				
			} catch (DBFWException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DBConnectionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return result;
			
			
		}
	public static List ViewArticle(final int iid) throws DBFWException {
		ConnectionHolder ch=null;
		Connection con=null;
		List result=null;
		
		try {
			ch=ConnectionHolder.getInstance();
			con=ch.getConnection();
			
			final ParamMapper ARTICLE=new ParamMapper()
			{
				public void mapParam(PreparedStatement preStmt)
				throws SQLException {
					preStmt.setInt(1,iid);	
				}
			};
			result=DBHelper.executeSelect(con,SqlMapper.VIEWARTICLE1,SqlMapper.VIEWARTICLE,ARTICLE);
							
		}
		 catch (DBConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
		// TODO Auto-generated method stub
		
	}
	public static List Viewfaculty() throws DBFWException {
		ConnectionHolder ch=null;
		Connection con=null;
		List result=null;
		
		try {
			ch=ConnectionHolder.getInstance();
			con=ch.getConnection();
			
			final ParamMapper FDETAILS1=new ParamMapper()
			{
				public void mapParam(PreparedStatement preStmt)
				throws SQLException {
					
					//preStmt.setInt(1,iid);
					
					
				}
			};
				

			result=DBHelper.executeSelect(con,SqlMapper.Faculty,SqlMapper.VIEWFACULTY,FDETAILS1);
					
				
				
		}
		 catch (DBConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
		// TODO Auto-generated method stub
		
	}
}
		
	


