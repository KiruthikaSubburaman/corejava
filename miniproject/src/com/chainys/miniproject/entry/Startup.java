package com.chainys.miniproject.entry;

import com.chainsys.miniproject.ui.AppointmentUi;
import com.chainsys.miniproject.ui.DoctorUi;
import com.chainsys.miniproject.ui.EmployeeUI;

public class Startup {
	public static void main(String args[]) {
		loadMenu();
	}

	private static void loadMenu() {
		System.out.println("Enter Menu :\n1->EmployeeMenu\n2->Doctor Menu\n3->Appointment Menu ");
		java.util.Scanner sc = new java.util.Scanner(System.in);
		try {
			int call = sc.nextInt();
			switch (call) {
			case 1:
				loadEmployeeMenu();
				break;
			case 2:
				loadDoctorMenu();
				break;
			case 3:
				loadAppointmentMenu();
				break;
			}
		} finally {
			sc.close();
		}
	}

	private static void loadEmployeeMenu() {
		System.out.println(
				"Enter Employee Method :\n1=addEmployee\n2=getEmployeeById\n3=updateEmployee\n4=updateEmployeeFirstName\n5=updateEmployeeSalary\n6=deleteEmployee\n7=getAllEmployeeDetails");
		java.util.Scanner sc = new java.util.Scanner(System.in);
		try {
			int call = sc.nextInt();

			switch (call) {
			case 1:
				EmployeeUI.addNewEmployee();
				break;

			case 2:
				EmployeeUI.fetchEmployeeById();
				break;
			case 3:
				EmployeeUI.UpdateEmployee();
				break;
			case 4:
				EmployeeUI.updateFirstnameOfEmployee();
				break;
			case 5:
				EmployeeUI.updateSalaryOfEmployee();
				break;
			case 6:
				EmployeeUI.deleteEmployee();
				break;
			case 7:
				EmployeeUI.fetchAllEmployee();
				break;
			}
		} finally {
			sc.close();
		}
	}

	private static void loadDoctorMenu() {
		System.out.println(
				"Enter Doctor Method :\n1=addNewDoctor\n2=viewDoctorsDetailsById\n3=viewAllDoctorsDetails\n4=updateDoctorDetails\n5=deleteDoctorDetails ");
		java.util.Scanner sc = new java.util.Scanner(System.in);
		try {
			int call = sc.nextInt();
			switch (call) {
			case 1:
				DoctorUi.addNewDoctor();
				break;
			case 2:
				DoctorUi.viewDoctorDetails();;
				break;
			case 3:
				DoctorUi.ViewAllDoctorDetails();
				break;
			case 4:
				DoctorUi.updateDocDetails();
				break;
			case 5:
				DoctorUi.deleteDoctordetails();
				break;
			}
		} finally {
			sc.close();
		}
	}

	private static void loadAppointmentMenu() {
		System.out.println(
				"Enter Method : \n1=addNewAppointment\n2=viewAppointmentDetails\n3=updateAppointmentDetails\n4=allAppointmentDetails\n5=deleteAppointmentDetails");
		java.util.Scanner sc = new java.util.Scanner(System.in);
		try {
			int call = sc.nextInt();
			switch (call) {
			case 1:
				AppointmentUi.addNewAppointments();
				break;
			case 2:
				AppointmentUi.viewAppointmentDetails();
				break;
			case 3:
				AppointmentUi.updateAppDetails();
				break;
			case 4:
				AppointmentUi.ViewAllAppointmentDetails();
				break;
			case 5:
				AppointmentUi.deleteAppointmentDetails();
				break;

			}
		} finally {
			sc.close();
		}
	}

}