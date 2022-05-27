package com.chainsys.webapp.first;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GlobalState
 */
public class GlobalState extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GlobalState() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<html><head><title>HelloWorld</title></head><body>");
        Enumeration<String> names =request.getParameterNames();
        while(names.hasMoreElements()) {
        	String parameterName=names.nextElement();
        	System.out.println(parameterName);
        	String [] values =request.getParameterValues(parameterName);
        	int length= values.length;
        	for(int i=0;i<length;i++)
        	{
        		System.out.println("Values : "+values[i]);
        	}
        }
        //collection of strings
        /*String submitValue = request.getParameter("submit");
        ServletContext ctx=this.getServletContext();//Get handle to serveletContext maintained by Tom cat server
        if (submitValue.equals("set")) 
        {
            String salaryInput = request.getParameter("salary");
            ctx.setAttribute("ctxsalary", salaryInput);//Store data in serveletContext for each user
            //ctx.setAtrribute()stores the data in collection using key and value
            //ctxsalary=key, salaryInput= value.
            out.println("<hl>Value Set</hl>" + salaryInput);
        }else if (submitValue.equals("fetch")) {
			//String contextSalary=context.getAttribute("salary");
			String contextSalary=(String)ctx.getAttribute("ctxsalary");
			if(contextSalary==null)
			{
				 out.println("<h1>SESSION NOT YET SET!!! </h1>");
	        }
	            out.println("<h1>Value fetched</h1>" + contextSalary);// returning value from session attribute
	        }*/
        out.println("<input type='hidden' value='50000' name='bonus' id='bonus'/>");
	        out.println("</body></html>");
	}
}




