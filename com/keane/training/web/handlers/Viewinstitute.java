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
import com.keane.training.domain.Institute;
import com.keane.training.domain.Student;

public class Viewinstitute implements HttpRequestHandler{


	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	

		try {
			
		
			PrintWriter pr=response.getWriter();
			List<Institute> s=null;
		AdminDAO d=new AdminDAO();
		//	int iid=Integer.parseInt(request.getParameter("iid"));
			s=d.ViewInstitute();
			pr.println("<center>");
			   pr.println("<table border='2'>");
			   pr.println("<tr><th>Institute Id</th></tr>");
			if(!(s.isEmpty())){
				for(Iterator it=s.iterator();it.hasNext();){
					Institute s1=(Institute)it.next();
					 pr.println("<tr><td>"+s1.getIid()+"\t"+"</td></tr><br>");
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


