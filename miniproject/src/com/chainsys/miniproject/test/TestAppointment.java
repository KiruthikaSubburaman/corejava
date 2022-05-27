package com.chainsys.miniproject.test;

import java.sql.Date;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import com.chainsys.miniproject.dao.AppointmentDao;
import com.chainsys.miniproject.pojo.Appointment;

public class TestAppointment {
	public static void testInsertAppointments()
	{
			Appointment newapp = new Appointment();
			newapp.setApp_id(19);
			Calendar c1=Calendar.getInstance();
			java.util.Date newDate=c1.getTime();
			newapp.setApp_date(newDate);
			newapp.setDoctor_id(121);
			newapp.setPatient_name("praveena");
			newapp.setFees_collected(1000);
			newapp.setFees_nature("Standard");
			int result = AppointmentDao.insertAppointment(newapp);
			System.out.println("Record Inserted : " + result);
	}

	public static void testUpdateAppointments()
	{
		try {
			Appointment oldapp = AppointmentDao.getAppointmentById(18);
			System.out.println(oldapp.getApp_id() + " " + oldapp.getDoctor_id() + " " + oldapp.getPatient_name());
			Calendar c1 = Calendar.getInstance();
			java.util.Date date = c1.getTime();
			oldapp.setApp_date((Date) date);
			oldapp.setDoctor_id(81);
			oldapp.setPatient_name("sunandha");
			oldapp.setFees_collected(3000);
			oldapp.setFees_nature("Standard");
			int result = AppointmentDao.updateAppointment(oldapp);
			System.out.println("Record Updated : " + result);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	public static void testDeleteAppointment()
	{
		try {
			int result = AppointmentDao.deleteAppointment(18);
			System.out.println("Records Deleted :" + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testGetAppointmentById()
	{
		try {
			Appointment app = AppointmentDao.getAppointmentById(15);
			System.out.println(app.getApp_id() + " " + app.getDoctor_id() + " " + app.getPatient_name());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testGetAllAppointment()
	{
		try {
			List<Appointment> allAppointments = AppointmentDao.getAllAppointment();
			Iterator<Appointment> docIterator = allAppointments.iterator();
			while(docIterator.hasNext())
			{
				Appointment app = docIterator.next();
				System.out.println(app.getApp_id() + " " + app.getDoctor_id() + " " + app.getPatient_name());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
