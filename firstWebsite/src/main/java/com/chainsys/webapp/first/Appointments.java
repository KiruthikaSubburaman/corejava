package com.chainsys.webapp.first;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.commonutil.InvalidInputDataException;
import com.chainsys.commonutil.Validator;
import com.chainsys.miniproject.dao.AppointmentDao;
import com.chainsys.miniproject.pojo.Appointment;
import com.chainsys.miniproject.pojo.Doctor;
import com.chainsys.miniproject.pojo.Employee;

/**
 * Servlet implementation class Appointments
 */
public class Appointments extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Appointments() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		List<Appointment> applist = AppointmentDao.getAllAppointment();
		Iterator<Appointment> appItr = applist.iterator();
		while (appItr.hasNext()) {
			Appointment app = appItr.next();
			out.println("</hr>");
			out.println("App id:" + app.getApp_id() + "," + "App Date" + app.getApp_date() + "," + "Patient name:"
					+ app.getPatient_name() + "," + "Doctor Id:" + app.getApp_id() + "," + "Fees Collected:"
					+ app.getFees_collected() + "," + "Fees Nature:" + app.getFees_nature() + "</p>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getParameter("submit").equals("Add")) {
		PrintWriter out = response.getWriter();
		Appointment newapp = null;
		int result = 0;
		int appId = 0;
		String testname = null;
		try {
			newapp = new Appointment();
			String id = request.getParameter("id");
			try {
				Validator.checkStringForParseInt(id);
			} catch (InvalidInputDataException e) {
				e.printStackTrace();
				return;

			}
			appId = Integer.parseInt(id);
			try {
				Validator.CheckNumberForGreaterThanZero(appId);
			} catch (InvalidInputDataException e) {
				e.printStackTrace();
				return;
			}
			newapp.setApp_id(appId);
			SimpleDateFormat App_dateFormate = new SimpleDateFormat("dd/MM/yyyy");
			String App_Date = request.getParameter("appdate");
			// Date hire_date=hire_dateFormate.parse(emp_HireDate);

			java.util.Date newDate = null;
			try {
				newDate = App_dateFormate.parse(App_Date);
			} catch (ParseException e) {
				e.printStackTrace();
				return;
			}

			newapp.setApp_date(newDate);
			String Docid = request.getParameter("Docid");
			try {
				Validator.checkStringForParseInt(Docid);
			} catch (InvalidInputDataException e) {
				e.printStackTrace();
				return;
			}
			int doc_id = Integer.parseInt(Docid);
			try {
				Validator.CheckNumberForGreaterThanZero(doc_id);
			} catch (InvalidInputDataException e) {
				e.printStackTrace();
				return;
			}
			newapp.setDoctor_id(doc_id);
			String patientname = request.getParameter("patientname");
			testname = patientname;
			try {
				Validator.checkStringOnly(testname);
			} catch (InvalidInputDataException e) {
				e.printStackTrace();
				return;
			}
			try {
				Validator.checklengthOfString(patientname);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
				return;
			}
			newapp.setPatient_name(patientname);
			String feescollected = request.getParameter("feescollected");
			try {
				Validator.checkStringForParseInt(feescollected);
			} catch (InvalidInputDataException e) {
				e.printStackTrace();
				return;
			}
			int fees = Integer.parseInt(feescollected);

			try {
				Validator.CheckNumberForGreaterThanZero(fees);
			} catch (InvalidInputDataException e) {
				e.printStackTrace();
				return;
			}
			newapp.setFees_collected(fees);
			String feesnature = request.getParameter("feesnature");
			try {
				Validator.checkStringOnly(feesnature);
			} catch (InvalidInputDataException e) {
				e.printStackTrace();
				return;
			}
			newapp.setFees_nature(feesnature);
			result = AppointmentDao.insertAppointment(newapp);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
		}
		out.println("<div>" + "Add New Appointment: " + result + "</div>");
	}else if(request.getParameter("submit").equals("update")) {
		doPut(request,response);
	}else if(request.getParameter("submit").equals("Delete")) {
		doDelete(request,response);
	}
	
}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
        Appointment app = null;
        int app_id=0;
        int result=0;
		try {
			app=new Appointment();
			String id=request.getParameter("id");
			try {
			Validator.checkStringForParseInt(id);
		}catch(InvalidInputDataException e) {
			e.printStackTrace();
			return;
			
		}
		 app_id=Integer.parseInt(id);
		try {
			Validator.CheckNumberForGreaterThanZero(app_id);
		}catch(InvalidInputDataException e) {
			e.printStackTrace();
			return;
		}

		app.setApp_id(app_id);
		
		SimpleDateFormat appFormate = new SimpleDateFormat("dd/MM/yyyy");
		String app_date = request.getParameter("appdate");
		try {
			Validator.checkDate(app_date);
		}catch(InvalidInputDataException e) {
			e.printStackTrace();
			return;
		}
	
		try {
			app.setApp_date(appFormate.parse(app_date));
		} catch (ParseException e) {
			e.printStackTrace();
			return;
		}
		String doc_Id = request.getParameter("docid");
		try {
			Validator.checkStringForParseInt(doc_Id);
		}catch(InvalidInputDataException e) {
			e.printStackTrace();
			return;
		}
		int doctor_id=Integer.parseInt(doc_Id);
		try {
			Validator.CheckNumberForGreaterThanZero(doctor_id);
		}catch(InvalidInputDataException e) {
			e.printStackTrace();
			return;
		}
		app.setDoctor_id(doctor_id);
		
		String patient = request.getParameter("name");
		try {
			Validator.checkStringOnly(patient);
		}catch(InvalidInputDataException e) {
			e.printStackTrace();
			return;
		}
		app.setPatient_name(patient);
		String fees_collected = request.getParameter("fees");
		try {
			Validator.checkStringForParseInt(fees_collected);
		}catch(InvalidInputDataException e) {
			e.printStackTrace();
			return;
		}
		int fees=Integer.parseInt(fees_collected);
		
		try {
			Validator.CheckNumberForGreaterThanZero(fees);
		}catch(InvalidInputDataException e) {
			e.printStackTrace();
			return;
		}
		app.setFees_collected(fees);
		String fees_nature = request.getParameter("fees_nature");
		try {
			Validator.checkStringOnly(fees_nature);
		}catch(InvalidInputDataException e) {
			e.printStackTrace();
			return;
		}
		app.setFees_nature(fees_nature);
        result = AppointmentDao.updateAppointment(app);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
		}
		out.println("<div> Updated Appointment detail: " + result + "</div>");
		}
	

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String app_id=request.getParameter("id");
		try {
			Validator.checkStringForParseInt(app_id);
		}catch(InvalidInputDataException e) {
			e.printStackTrace();
			return;
		}
		int id=Integer.parseInt(app_id);
		int result = AppointmentDao.deleteAppointment(id);
		out.println(result+"row deleted");
		
	}

}
	

