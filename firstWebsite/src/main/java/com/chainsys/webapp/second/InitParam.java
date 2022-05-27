package com.chainsys.webapp.second;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InitParam
 */
public class InitParam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InitParam() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		Enumeration<String> initParamNames = getInitParameterNames();//This method returns the names of the servlet's initialization parameters
		while(initParamNames.hasMoreElements())  //hasMoreElements() Tests if this enumeration contains more elements.
				
		{
			String name=initParamNames.nextElement();//nextElement() Returns the next element of this enumeration if this enumeration object has at least one more element to provide.
			out.print(name+ " : "+getInitParameter(name)+"</p>");
		}
		//context-param
		String adminEmail=getServletContext().getInitParameter("AdministratorEmail");
		out.print(adminEmail +"</p>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
