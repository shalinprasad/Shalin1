
package com.keane.training.web.handlers;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import com.keane.mvc.HttpRequestHandler;
import com.keane.training.dao.DAOAppException;
import com.keane.training.dao.RegisterDAO;
import com.keane.training.dao.StudentDAO;
import com.keane.training.domain.Student;
import com.keane.training.domain.User;


public class Login implements HttpRequestHandler {
	static Logger log = Logger.getLogger(Login.class);

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		StudentDAO dao = new StudentDAO();
		Student user = new Student();
		user.setSid(Integer.parseInt(request.getParameter("sid")));
//		
		user.setSpass(request.getParameter("spass"));

		try {
			
//		
			List finalres=new ArrayList();
				 finalres = StudentDAO.LoginStudent(user);
				if (!(finalres.isEmpty())) {

					RequestDispatcher dispatcher = request
							.getRequestDispatcher("..\\pages\\home.jsp");
					request.setAttribute("success",
							"Login successful...!!");
					request.setAttribute("details", user);
					dispatcher.forward(request, response);
				}
			}
		 catch (Exception e) {
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("error.jsp");
			request.setAttribute("Err", e.getMessage());
			dispatcher.forward(request, response);
		}
	}

}


