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
import com.keane.training.dao.AdminDAO;
import com.keane.training.domain.Student;

public class ViewStudent1 implements HttpRequestHandler{


	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	

		try {
			
		
			PrintWriter pr=response.getWriter();
			List<Student> s=null;
		AdminDAO d=new AdminDAO();
			s=d.StudentDetails12();
			pr.println("<center>");
			   pr.println("<table border='2'>");
			   pr.println("<tr><th>StudentId</th><th> NAME</th><th>Qualification" +
			   		"</th><th> Phonenumber</th><th>Address</th><th>Email" +
			   		"</th><th>Institute Id</th></tr>");
			if(!(s.isEmpty())){
				for(Iterator it=s.iterator();it.hasNext();){
					Student s1=(Student)it.next();
					 pr.println("<tr><td>"+s1.getSid()+"\t"+"</td><td>"+s1.getSname()+"\t"
							 +"</td><td>"+s1.getSqual()+"\t"+"</td><td>"+s1.getContact()+"\t"+
							 "</td><td>"+s1.getSaddr()+"\t"+"</td><td>"+s1.getSemail()+"\t"+
							 "\t"+"</td><td>"+s1.getIid()+"\t"+"</td></tr><br>");
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


