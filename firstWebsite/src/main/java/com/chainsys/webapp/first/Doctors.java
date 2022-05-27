package com.chainsys.webapp.first;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.commonutil.InvalidInputDataException;
import com.chainsys.commonutil.Validator;
import com.chainsys.miniproject.dao.AppointmentDao;
import com.chainsys.miniproject.dao.DoctorDao;
import com.chainsys.miniproject.pojo.Doctor;

/**
 * Servlet implementation class Doctors
 */
public class Doctors extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Doctors() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
        PrintWriter out=response.getWriter();
        response.setContentType("text/html");
        List<Doctor> doclist = DoctorDao.getAllDoctor();
        Iterator<Doctor> docItr = doclist.iterator();
        while (docItr.hasNext()) 
        {
            Doctor doc = docItr.next();
            out.println("</hr>");
            out.println("doc id:"+ doc.getDoctor_id()+"doc name:"+doc.getName() + "Doc dob:"+doc.getDob()+ "speciality :"+doc.getSpeciality() +"city:"+ doc.getCity() + "phone no:"+ doc.getPhone_number()+"standard_fees:"  + doc.getStandard_fees()+"</p>");
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		if(request.getParameter("submit").equals("ADDDOC"))
		{
		PrintWriter out = response.getWriter();
        Doctor newdoc = null;
        int result = 0;
        int docId = 0;
        String testname = null;
        try
        {
        	newdoc = new Doctor();
            String id = request.getParameter("id");
            try
            {
                Validator.checkStringForParseInt(id);
            } catch (InvalidInputDataException err) 
            {
                err.printStackTrace();
            }
            docId = Integer.parseInt(id);
            try 
            {
                Validator.CheckNumberForGreaterThanZero(docId);
            } catch (InvalidInputDataException err) 
            {
                err.printStackTrace();
            }
            newdoc.setDoctor_id(docId);
            String name = request.getParameter("name");
            testname = name;
            try 
            {
                Validator.checkStringOnly(testname);
            } catch (InvalidInputDataException e)
            {
                e.printStackTrace();
                return;
            }
            try
            {
                Validator.checklengthOfString(testname);
            } catch (InvalidInputDataException err)
            {
                err.printStackTrace();
                return;
            }
            newdoc.setName(name);
            SimpleDateFormat doc_dobFormate = new SimpleDateFormat("dd/MM/yyyy");
            String doc_Dob = request.getParameter("dob");
            Date newDate = null;
            try 
            {
                newDate = doc_dobFormate.parse(doc_Dob);
            } catch (ParseException e)
            {
                e.printStackTrace();
                return;
            }
            
            newdoc.setDob(newDate);
            String speciality = request.getParameter("speciality");
            testname = speciality;
            try
            {
                Validator.checkStringOnly(testname);
            } catch (InvalidInputDataException e) 
            {
                e.printStackTrace();
                return;
            }
            try
            {
                Validator.checklengthOfString(speciality);
            } catch (InvalidInputDataException err) 
            {
                err.printStackTrace();
                return;
            }
            newdoc.setSpeciality(speciality);
            String city = request.getParameter("city");
            testname = city;
            try
            {
                Validator.checkStringOnly(testname);
            } catch (InvalidInputDataException e) 
            {
                e.printStackTrace();
                return;
            }
            try
            {
                Validator.checklengthOfString(testname);
            } catch (InvalidInputDataException err) 
            {
                err.printStackTrace();
                return;
            }
            newdoc.setCity(city);       
            String phone_no =request.getParameter("phoneno");
    		testname=phone_no;
    		try 
    		{
    			Validator.checkPhone(phone_no);
    		} catch (InvalidInputDataException e) 
    		{
    			e.printStackTrace();
    			return;
    		}
    		newdoc.setPhone_number(Long.parseLong(phone_no));
            String std_fees = request.getParameter("fees");
            try
            {
                Validator.checkStringForParseInt(std_fees);
            } catch (InvalidInputDataException err)
            {
                err.printStackTrace();
                return;
            }
            float salParse = Float.parseFloat(std_fees);
            try 
            {
                Validator.CheckNumberForGreaterThanZero(salParse);
            } catch (InvalidInputDataException err) {
                err.printStackTrace();
                return;
            }
            newdoc.setStandard_fees(salParse);
            result = DoctorDao.insertDoctor(newdoc);
        } catch (Exception e) 
        {
            e.printStackTrace();
            return;
        } 
        out.println("<div> Add New Doctor:"+ result+"</div>");
		} else if (request.getParameter("submit").equals("UPDATE_DOC")) {
			doPut(request, response);
		} else if (request.getParameter("submit").equals("DELETE_DOC")) {
			doDelete(request, response);
	}
	}
	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();
        Doctor newdoc = null;
        int result = 0;
        int docId = 0;
        String testname = null;
        try
        {
        	newdoc = new Doctor();
            String id = request.getParameter("id");
            try
            {
                Validator.checkStringForParseInt(id);
            } catch (InvalidInputDataException err) 
            {
                err.printStackTrace();
                return;
            }
            docId = Integer.parseInt(id);
            try 
            {
                Validator.CheckNumberForGreaterThanZero(docId);
            } catch (InvalidInputDataException err) 
            {
                err.printStackTrace();
                return;
            }
            newdoc.setDoctor_id(docId);
            String name = request.getParameter("name");
            testname = name;
            try 
            {
                Validator.checkStringOnly(testname);
            } catch (InvalidInputDataException e)
            {
                e.printStackTrace();
                return;
            }
            try
            {
                Validator.checklengthOfString(testname);
            } catch (InvalidInputDataException err)
            {
                err.printStackTrace();
                return;
            }
            newdoc.setName(name);
            SimpleDateFormat doc_dobFormate = new SimpleDateFormat("dd/MM/yyyy");
            String doc_Dob = request.getParameter("dob");
            Date newDate = null;
            try 
            {
                newDate = doc_dobFormate.parse(doc_Dob);
            } catch (ParseException e)
            {
                e.printStackTrace();
                return;
            }
            
            newdoc.setDob(newDate);
            String speciality = request.getParameter("speciality");
            testname = speciality;
            try
            {
                Validator.checkStringOnly(testname);
            } catch (InvalidInputDataException e) 
            {
                e.printStackTrace();
                return;
            }
            try
            {
                Validator.checklengthOfString(speciality);
            } catch (InvalidInputDataException err) 
            {
                err.printStackTrace();
                return;
            }
            newdoc.setSpeciality(speciality);
            String city = request.getParameter("city");
            testname = city;
            try
            {
                Validator.checkStringOnly(testname);
            } catch (InvalidInputDataException e) 
            {
                e.printStackTrace();
                return;
            }
            try
            {
                Validator.checklengthOfString(testname);
            } catch (InvalidInputDataException err) 
            {
                err.printStackTrace();
                return;
            }
            newdoc.setCity(city);       
            String phoneno =request.getParameter("phoneno");
    	
    		try 
    		{
    			Validator.checkPhone(phoneno);
    		} catch (InvalidInputDataException e) 
    		{
    			e.printStackTrace();
    			return;
    		}
    		newdoc.setPhone_number(Long.parseLong(phoneno));
            String std_fees = request.getParameter("fees");
            try
            {
                Validator.checkStringForParseInt(std_fees);
            } catch (InvalidInputDataException err)
            {
                err.printStackTrace();
                return;
            }
            float salParse = Float.parseFloat(std_fees);
            try 
            {
                Validator.CheckNumberForGreaterThanZero(salParse);
            } catch (InvalidInputDataException err) {
                err.printStackTrace();
                return;
            }
            newdoc.setStandard_fees(salParse);
            result = DoctorDao.updateDoctor(newdoc);
            System.out.println();
            } catch (Exception e) 
        {
            e.printStackTrace();
            return;
        } 
        out.println("<div> update doctor: " + result + "</div>");
        
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		String id = null;
		try {
			id = request.getParameter("id");
			Validator.checkStringForParseInt(id);
		} catch (InvalidInputDataException e) 
		{
			e.printStackTrace();
			return;
		}
		int doc_id = Integer.parseInt(id);
		try {
			Validator.CheckNumberForGreaterThanZero(doc_id);
		} catch (InvalidInputDataException e) {
			e.printStackTrace();
			return;
		}
		int result =DoctorDao.deleteDoctor(doc_id);
		out.println(result + "row deleted");
		
	}

}
