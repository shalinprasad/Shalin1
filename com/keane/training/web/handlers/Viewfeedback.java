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
import com.keane.training.domain.Feedback;

public class Viewfeedback implements HttpRequestHandler{


	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	

		try {
			
		
			PrintWriter pr=response.getWriter();
			List<Feedback> s=null;
			InstituteDAO d=new InstituteDAO();
			int iid=Integer.parseInt(request.getParameter("iid"));
			s=d.ViewFeedback(iid);
			pr.println("<center>");
			   pr.println("<table border='2'>");
			   pr.println("<tr><th>StudentId</th><th> Institute Id</th><th>Feedback" +
			   		"</th></tr>");
			if(!(s.isEmpty())){
				for(Iterator it=s.iterator();it.hasNext();){
					Feedback s1=(Feedback)it.next();
					 pr.println("<tr><td>"+s1.getSid()+"\t"+"</td><td>"+s1.getIid()+"\t"
							 +"</td><td>"+s1.getFeedback()+"\t"+"</td></tr><br>");
				}
			}else{
				RequestDispatcher dispatcher = request
				.getRequestDispatcher("..\\pages\\InstituteHome.jsp");
		request.setAttribute("success",
				"Ooops no feedback ....");
		request.setAttribute("details", s);
		dispatcher.forward(request, response);
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


