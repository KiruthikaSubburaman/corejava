package com.chainsys.jspproject.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.jspproject.pojo.Employee;


public class EmployeeDao {

	/**
	 * METHODS: getConnection() 
	 * insertEmployee(Employee newemp) 
	 * getEmployeeById(int id) 
	 * getAllEmployees() 
	 * updateEmployee(Employee newemp) 
	 * deleteEmployee(int id)
	 */

	public static Connection getConnection() {
		String drivername = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "system";
		String pwd = "Nithikiru@1927";

		try 
		{
			Class.forName(drivername);
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, pwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	private static java.sql.Date convertTosqlDate(java.util.Date date) {
		java.sql.Date sqldate = new java.sql.Date(date.getTime());
		return sqldate;

	}
// To insert new row to the table employees
	public static int insertEmployee(Employee newemp)
	{
		String insertquery = "insert into employees(EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,HIRE_DATE,JOB_ID,SALARY) values (?,?,?,?,?,?,?)";
		Connection con = null;
		int rows =0;
		PreparedStatement stmt = null;
		try 
		{
			con = getConnection();
			stmt = con.prepareStatement(insertquery);
			stmt.setInt(1, newemp.getEmp_id());
			stmt.setString(2, newemp.getFirst_name());
			stmt.setString(3, newemp.getLast_name());
			stmt.setString(4, newemp.getEmail());
			// convert java.util.Date to java.sql.date
			stmt.setDate(5, convertTosqlDate(newemp.getHire_date()));
			stmt.setString(6, newemp.getJob_id());
			stmt.setFloat(7, newemp.getSalary());

			rows = stmt.executeUpdate();
		} catch (SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			try {
				stmt.close();
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
			try 
			{
				con.close();
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		return rows;
	}
// for updating all the columns of the table
	public  static int updateEmployee(Employee newemp) 
	{
		String updatequery = "update employees set FIRST_NAME=?,LAST_NAME=?,EMAIL=?,HIRE_DATE=?,JOB_ID=?,SALARY=? where employee_id=?";
		Connection con = null;
		int rows = 0;
		PreparedStatement stmt = null;
		try 
		{
			con = getConnection();
			stmt = con.prepareStatement(updatequery);
			stmt.setString(1, newemp.getFirst_name());
			stmt.setInt(7, newemp.getEmp_id());
			stmt.setString(2, newemp.getLast_name());
			stmt.setString(3, newemp.getEmail());
			// convert java.util.Date to java.sql.date
			stmt.setDate(4, convertTosqlDate(newemp.getHire_date()));
			stmt.setString(5, newemp.getJob_id());
			stmt.setFloat(6, newemp.getSalary());

			stmt.executeUpdate();
			rows = stmt.executeUpdate();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}finally 
		{
			try
			{
				stmt.close();
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
			try
			{
				con.close();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}

		return rows;
	}
	 
	public static int updateEmployeeFirstName(int id,String fname) 
	{
		String updatequery = "update employees set FIRST_NAME=? where employee_id=?";
		Connection con = null;
		int rows = 0;
		PreparedStatement ps = null;
		try 
		{
			con = getConnection();
			ps = con.prepareStatement(updatequery);
			ps.setString(1, fname);
			ps.setInt(2, id);
			ps.executeUpdate();
			rows = ps.executeUpdate();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}finally
		{
			try 
			{
				ps.close();
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
			try 
			{
				con.close();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}

		return rows;
	}
	public static int updateEmployeeSalary(int id, float salary) 
	{
		String updatequery = "update employees set SALARY=? where employee_id=?";
		Connection con = null;
		int rows = 0;
		PreparedStatement ps = null;
		try
		{
			con = getConnection();
			ps = con.prepareStatement(updatequery);
			ps.setDouble(1, salary );
			ps.setInt(2, id);
			ps.executeUpdate();
			rows = ps.executeUpdate();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}finally 
		{
			try 
			{
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try 
			{
				con.close();
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		return rows;
	}
	public static int deleteEmployee(int id) 
	{
		String deletequery = "delete from employees where EMPLOYEE_ID=?";
		Connection con = null;
		int rows = 0;
		PreparedStatement ps = null;
	
		try 
		{
			con = getConnection();
			ps = con.prepareStatement(deletequery);
			ps.setInt(1, id);
			ps.executeUpdate();
			rows = ps.executeUpdate();	
		}catch(SQLException e) 
		{
			e.printStackTrace();
		}finally
		{
			try 
			{
				ps.close();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
			try 
			{
				con.close();
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		return rows;
	}
	//To retrieve specific Employee data using employee_id
	public static Employee getEmployeeById(int id) 
	{
		Employee emp =null;
		String selectquery = "select EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,HIRE_DATE,JOB_ID,SALARY  from Employees where employee_id = ? ";
		Connection con = null;
		PreparedStatement ps = null;
		 ResultSet rs  = null;
		try {
			con = getConnection();
			ps = con.prepareStatement(selectquery);
			ps.setInt(1, id);
			rs =ps.executeQuery();
			emp = new Employee();
			   if(rs.next()) {
		          emp.setEmp_id(rs.getInt(1));
		          emp .setFirst_name(rs.getString(2));
		          emp.setLast_name(rs.getString(3));
		          emp.setEmail(rs.getString(4));
		          java.util.Date date = new java.util.Date(rs.getDate(5).getTime());
		          emp.setHire_date(date);
		          emp.setJob_id(rs.getString(6));
		          emp.setSalary(rs.getFloat(7));
		        }
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return emp;
	
	}
	//To retrieve all employee data 
	 public static List<Employee> getAllEmployee(){
		 List<Employee> listOfEmployees = new ArrayList<Employee>();
		 Employee emp =null;
			String selectquery = "select EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,HIRE_DATE,JOB_ID,SALARY  from Employees ";
			Connection con = null;
			PreparedStatement ps = null;
			 ResultSet rs  = null;
			try {
				con = getConnection();
				ps = con.prepareStatement(selectquery);
				rs =ps.executeQuery();
				while(rs.next()) 
				{
					  emp = new Employee();
			          emp.setEmp_id(rs.getInt(1));
			          emp .setFirst_name(rs.getString(2));
			          emp.setLast_name(rs.getString(3));
			          emp.setEmail(rs.getString(4));
			          java.util.Date date = new java.util.Date(rs.getDate(5).getTime());
			          emp.setHire_date(date);
			          emp.setJob_id(rs.getString(6));
			          emp.setSalary(rs.getFloat(7));
			          listOfEmployees.add(emp);
			   }
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					rs.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		 return listOfEmployees;
	 }
}