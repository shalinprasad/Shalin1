package com.keane.training.web.handlers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.keane.mvc.HttpRequestHandler;
import com.keane.training.dao.InstituteDAO;
import com.keane.training.domain.Institute;


public class InstituteLogin implements HttpRequestHandler {
	static Logger log = Logger.getLogger(Login.class);

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		InstituteDAO dao = new InstituteDAO();
		Institute user = new Institute();
		user.setIname(request.getParameter("iname"));
//		user.setSname(request.getParameter("sname"));
//		user.setSqual(request.getParameter("squal"));
//		user.setContact(request.getParameter("scontact"));
//		user.setSaddr(request.getParameter("saddr"));
//		user.setSemail(request.getParameter("semail"));
		user.setIpass(request.getParameter("ipass"));
//		user.setIid(Integer.parseInt(request.getParameter("iid")));
		

//		boolean isExists;
		try {
			
//			isExists = dao.validateUser(user.getSid());
//
//			if (isExists) {
//				log.info("User already registered");
//				RequestDispatcher dispatcher = request
//						.getRequestDispatcher("..\\pages\\studentReg.jsp");
//				request.setAttribute("Err",
//						"User already registered with the system");
//				dispatcher.forward(request, response);
//			} else {
//				user.setSpass("NttData@"
//						+ Integer.toString(user.getSid()));
			List finalres=new ArrayList();
				 finalres = InstituteDAO.LoginInstitute(user);
				if (!(finalres.isEmpty())) {

					RequestDispatcher dispatcher = request
							.getRequestDispatcher("..\\pages\\home.jsp");
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
