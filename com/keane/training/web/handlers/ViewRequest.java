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
import com.keane.training.dao.InstituteDAO;
import com.keane.training.domain.Request;

public class ViewRequest  implements HttpRequestHandler{


	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	

		try {
			
		
			PrintWriter pr=response.getWriter();
			List<Request> s=null;
			InstituteDAO d=new InstituteDAO();
		int iid=Integer.parseInt(request.getParameter("iid"));
			s=d.ViewRequests(iid);
			pr.println("<center>");
			   pr.println("<table border='2'>");
			   pr.println("<tr><th>StudentId</th><th>InstituteId</th><th>Request" +
			   		"</th></tr>");
			if(!(s.isEmpty())){
				for(Iterator it=s.iterator();it.hasNext();){
					Request s1=(Request)it.next();
					 pr.println("<tr><td>"+s1.getSid()+"\t"+"</td><td>"+s1.getIid()+"\t"
							 +"</td><td>"+s1.getComplaint()+"\t"+"</td></tr><br>");
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
