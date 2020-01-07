package com.keane.training.web.handlers;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import com.keane.mvc.HttpRequestHandler;
import com.keane.training.dao.AdminDAO;
import com.keane.training.dao.InstituteDAO;
public class Approve implements HttpRequestHandler{
static Logger log = Logger.getLogger(Approve.class);
 
 public void handle(HttpServletRequest request, HttpServletResponse response)
 throws ServletException, IOException {
 RequestDispatcher r1=request.getRequestDispatcher("AppSuc.jsp");
AdminDAO ad=new AdminDAO();
 PrintWriter out=response.getWriter();
 int i=Integer.parseInt(request.getParameter("sid"));
 int stat=Integer.parseInt(request.getParameter("status"));
 int s=ad.InsertStatus(i,stat);
 if(s!=0)
 {
 out.println("<p>Approved Student succcessfully</p>");
 }
 else
 {
 out.println("<p>Not Approved</p>");
 RequestDispatcher r2=request.getRequestDispatcher("ApproveStud.jsp");
 r2.include(request, response);
 }
 r1.include(request, response);
 }
}