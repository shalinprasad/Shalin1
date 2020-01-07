package com.keane.training.web.handlers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.keane.mvc.HttpRequestHandler;

import com.keane.training.dao.StudentDAO;
import com.keane.training.domain.Faculty;

public class ViewFaculty implements HttpRequestHandler{


	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	

		try {
			
		
			PrintWriter pr=response.getWriter();
			List<Faculty> s=null;
			StudentDAO d=new StudentDAO();
			
			s=d.Viewfaculty();
			pr.println("<center>");
			   pr.println("<table border='2'>");
			   pr.println("<tr><th>FacultyId</th><th>Facultyname</th><th>FacultyDept" +
			   		"</th><th>InstituteId</th></tr>");
			if(!(s.isEmpty())){
				for(Iterator it=s.iterator();it.hasNext();){
					Faculty s1=(Faculty)it.next();
					 pr.println("<tr><td>"+s1.getFid()+"\t"+"</td><td>"+s1.getFname()+"\t"
							 +"</td><td>"+s1.getDept()+"\t"+"</td><td>"+s1.getIid()+"\t"+"</td></tr><br>");
				}
			}
			pr.println("</table>");
			   pr.println("</center>");
			}
		 catch (Exception e) {
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("error.jsp");
			request.setAttribute("Err", e.getMessage());
			dispatcher.forward(request, response);
		}
	}
}

