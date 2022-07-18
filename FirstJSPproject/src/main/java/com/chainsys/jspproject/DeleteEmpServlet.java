package com.chainsys.jspproject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.commonutil.ExceptionManager;
import com.chainsys.commonutil.InvalidInputDataException;
import com.chainsys.commonutil.Validator;
import com.chainsys.jspproject.dao.EmployeeDao;

/**
 * Servlet implementation class DeleteEmpServlet
 */
@WebServlet("/DeleteEmpServlet")
public class DeleteEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteEmpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		String source="DeleteEmployee";
		String message="<h1>error while "+source+"</h1>";
		PrintWriter out = response.getWriter();
		int result=0;
		String id = null;
		try {
			id = request.getParameter("id");
			Validator.checkStringForParseInt(id);
		} catch (InvalidInputDataException e) {
			message +=" error in Employee id input </p>";
			String errorPage=ExceptionManager.handleException(e, source, message);
			out.print(errorPage);
			return;
		}
		int emp_id = Integer.parseInt(id);
		try {
			Validator.CheckNumberForGreaterThanZero(emp_id);
		} catch (InvalidInputDataException e) {
			message +=" error in Employee id input </p>";
			String errorPage=ExceptionManager.handleException(e, source, message);
			out.print(errorPage);
			return;
		}
		result = EmployeeDao.deleteEmployee(emp_id);
        request.setAttribute("deleteemployee", result);
        RequestDispatcher rd = request.getRequestDispatcher("/deleteemp.jsp");
        rd.forward(request, response);
		
		try {
			out.close();
		} catch (Exception e) {
			message +="Message: "+e.getMessage();
			String errorPage=ExceptionManager.handleException(e, source, message);
			out.print(errorPage);
			return;
		}
		
		  
	}
	
	
}
