package com.keane.training.web.handlers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.keane.mvc.HttpRequestHandler;
import com.keane.training.dao.InstituteDAO;
import com.keane.training.dao.StudentDAO;
import com.keane.training.domain.Institute;
import com.keane.training.domain.Student;

public class InstituteReg implements HttpRequestHandler{
	static Logger log = Logger.getLogger(InstituteReg.class);

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		InstituteDAO dao = new InstituteDAO();
		Institute user = new Institute();
		user.setIid(Integer.parseInt(request.getParameter("iid")));
		user.setIname(request.getParameter("iname"));
		user.setAffdate(request.getParameter("affdate"));
		user.setIaddr(request.getParameter("iaddr"));
		user.setIseats(Integer.parseInt(request.getParameter("iseats")));
		user.setIcourse(Integer.parseInt(request.getParameter("icourse")));
		user.setIpass(request.getParameter("ipass"));
		user.setStatus(Integer.parseInt(request.getParameter("status")));
		

		try {
			
				int finalRes = InstituteDAO.InsertInstitute(user);
				if (finalRes > 0) {

					RequestDispatcher dispatcher = request
							.getRequestDispatcher("..\\pages\\success1.jsp");
					request.setAttribute("success",
							"User succesfully registered with the system");
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
