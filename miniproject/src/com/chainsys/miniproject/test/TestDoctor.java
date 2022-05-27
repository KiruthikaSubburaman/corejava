package com.chainsys.miniproject.test;

import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import com.chainsys.miniproject.dao.DoctorDao;
import com.chainsys.miniproject.pojo.Doctor;

public class TestDoctor {

	public static void testGetAllDoctor() {
		List<Doctor> allDoctor = DoctorDao.getAllDoctor();
		Iterator<Doctor> docIterator =allDoctor.iterator();
		while(docIterator.hasNext()) {
			Doctor doc = docIterator.next();
			System.out.println(doc.getDoctor_id()+" "+doc.getName()+" "+doc.getDob()+" "+doc.getCity()+" "+doc.getPhone_number());
		}
		}
		public static void testGetDoctorByDoctor_Id() {
			Doctor doc = DoctorDao.getDoctorByDoctor_Id(129);
			System.out.println(doc.getDoctor_id()+" "+doc.getName()+" "+doc.getDob()+" "+doc.getCity()+" "+doc.getPhone_number());
		}
		public static void testInsertDoctor() {
			Doctor newdoc = new Doctor();
			newdoc.setDoctor_id(121);
			newdoc.setName("Annie");
			Calendar c1 = Calendar.getInstance();
			java.util.Date newDate =c1.getTime();
			newdoc.setDob(newDate);
			newdoc.setSpeciality("ENT");
			newdoc.setCity("Tiruppur");
			newdoc.setPhone_number(9988776655l);
			newdoc.setStandard_fees(3000);
			int result = DoctorDao.insertDoctor(newdoc);
			System.out.println(result);
		}			
		public static void testUpdateDoctor() {
			Doctor oldDoctor = DoctorDao.getDoctorByDoctor_Id(123);
			System.out.println(oldDoctor.getDoctor_id()+" "+oldDoctor.getName()+" "+oldDoctor.getDob()+" "+oldDoctor.getSpeciality()+" "+oldDoctor.getCity()+" "+oldDoctor.getPhone_number()+" "+oldDoctor.getStandard_fees());
			oldDoctor.setDoctor_id(160);
			oldDoctor.setName("MERRY");
			Calendar c1 = Calendar.getInstance();
			java.util.Date newDate =c1.getTime();
			oldDoctor.setDob(new java.util.Date());
			oldDoctor.setDob(newDate);
			oldDoctor.setSpeciality("Dermatology");
			oldDoctor.setCity("Chennai");
			oldDoctor.setPhone_number(9999909876l);
			oldDoctor.setStandard_fees(3000);
			int result = DoctorDao.updateDoctor(oldDoctor);
			System.out.println(result);
		}		
		public static void testDeleteDoctor() {
			int result = DoctorDao.deleteDoctor(121);
			System.out.println(result+" row deleted!");
		}
		public static void testUpdateDoctorName()
        {
            int result = DoctorDao.updateDoctorName(123, "KIRUTHIKA");
            System.out.println(result +" row updated!");
        }

}