package com.secondWebapp.first;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Home
 */
@WebServlet(name="Home",urlPatterns = {"/home","/veedu"},description = "servlet for home page",
initParams = {@WebInitParam(name="phone",value="9876789045"),
		@WebInitParam(name="email",value="kiruthika@gmail.com")})
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Enumeration<String> initParamNames = getInitParameterNames();//This method returns the names of the servlet's initialization parameters
		while(initParamNames.hasMoreElements())  //hasMoreElements() Tests if this enumeration contains more elements.
				
		{
			String name=initParamNames.nextElement();//nextElement() Returns the next element of this enumeration if this enumeration object has at least one more element to provide.
			out.print(name+ " : "+getInitParameter(name)+"</p>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
