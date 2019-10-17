package org.oar.chain1App;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 String pname=req.getParameter("pn");
   	     String pqty=req.getParameter("pq");
   	     
   	     req.setAttribute("prdnm",pname);
   	     req.setAttribute("prdqt",pqty);
   	  
   	  RequestDispatcher rd=req.getRequestDispatcher("ss");
   	  rd.include(req,resp);
   	     
   	     //FETCH REQUEST OBJECT BACK FROM THE SCOPE//
   	     double totalsum=(double) req.getAttribute("tsum");
   	     
   	  PrintWriter out=resp.getWriter();
      out.println("<html><body bgcolor='yellow'>"
      		+ "<h1>Product Details Are"+pname+" "+totalsum+"</h1>"
      				+ "</body></html>");        
      out.flush();
      out.close();                                          //PRESENTATION LOGIC//
	
	}

}
