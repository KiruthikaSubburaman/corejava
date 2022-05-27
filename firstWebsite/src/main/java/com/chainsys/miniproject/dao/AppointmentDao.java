package com.chainsys.miniproject.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.miniproject.pojo.Appointment;
import com.chainsys.miniproject.pojo.Doctor;

public class AppointmentDao
{
	private static Connection getConnection()
	{
		String drivername = "oracle.jdbc.OracleDriver";
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
		Connection conn =null;
		try {
			conn  = DriverManager.getConnection(url, user, pwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn ;
	}
	

	public static java.sql.Date convertTosqlDate(java.util.Date date) {
		java.sql.Date sqldate = new java.sql.Date(date.getTime());
		return sqldate;

	}
	public static int insertAppointment(Appointment newapp)
	{
		String insertquery = "insert into Appointment(app_id,app_date,doctor_id,patient_name,fees_collected,fees_nature) values (?,?,?,?,?,?)";
		Connection con = null;
		int rows =0;
		PreparedStatement stmt = null;
		try 
		{
			con = getConnection();
			stmt = con.prepareStatement(insertquery);
			stmt.setInt(1, newapp.getApp_id());
			stmt.setDate(2, convertTosqlDate(newapp.getApp_date()));
			stmt.setInt(3, newapp.getDoctor_id());
			stmt.setString(4, newapp.getPatient_name());
			stmt.setFloat(5,newapp.getFees_collected());
			stmt.setString(6,newapp.getFees_nature());
			rows=stmt.executeUpdate();
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
	public  static int updateAppointment(Appointment newapp) 
	{
		String updatequery = "update Appointment set app_date=?,doctor_id=?,patient_name=?,fees_collected=?,fees_nature=? where app_id=?";
		Connection con = null;
		int rows = 0;
		PreparedStatement stmt = null;
		try 
		{
			con = getConnection();
			stmt = con.prepareStatement(updatequery);
			stmt.setInt(6, newapp.getApp_id());
			stmt.setDate(1, convertTosqlDate(newapp.getApp_date()));
			stmt.setInt(2, newapp.getDoctor_id());
			stmt.setString(3, newapp.getPatient_name());
			stmt.setFloat(4,newapp.getFees_collected());
			stmt.setString(5, newapp.getFees_nature());
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
	
	public static int deleteAppointment(int id) 
	{
		String deletequery = "delete from Appointment where app_id=?";
		Connection con = null;
		int rows = 0;
		PreparedStatement stmt = null;
	
		try 
		{
			con = getConnection();
			stmt = con.prepareStatement(deletequery);
			stmt.setInt(1, id);
			stmt.executeUpdate();
			rows = stmt.executeUpdate();	
		}catch(SQLException e) 
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
	public static Appointment getAppointmentById(int id) 
	{
		Appointment app =new Appointment();
		String selectquery = "select app_id,app_date,doctor_id,patient_name,fees_collected,fees_nature from Appointment where app_id= ? ";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs  = null;
		try {
			con = getConnection();
			stmt = con.prepareStatement(selectquery);
			stmt.setInt(1, id);
			rs =stmt.executeQuery();
			app=new Appointment();
			   while(rs.next()) {
				   app.setApp_id(rs.getInt(1));
				   java.util.Date date = new java.util.Date(rs.getDate(2).getTime());
				   app.setApp_date(date);;
				   app.setDoctor_id(rs.getInt(3));
				   app.setPatient_name(rs.getString(4));
				   app.setFees_collected(rs.getInt(5));
				   app.setFees_nature(rs.getString(6));
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
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return app;
	
	} 
	 public static List<Appointment> getAllAppointment(){
		 List<Appointment> listOfAppointment = new ArrayList<Appointment>();
		 Appointment app =null;
			String selectquery = "select app_id,app_date,doctor_id,patient_name,fees_collected,fees_nature from Appointment ";
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs  = null;
			try {
				con = getConnection();
				ps = con.prepareStatement(selectquery);
				rs =ps.executeQuery();
				while(rs.next()) 
				{
					   app=new Appointment();
					   app.setApp_id(rs.getInt(1));
					   java.util.Date date = new java.util.Date(rs.getDate(2).getTime());
					   app.setApp_date(date);
					   app.setDoctor_id(rs.getInt(3));
					   app.setPatient_name(rs.getString(4));
					   app.setFees_collected(rs.getInt(5)); 
					   app.setFees_nature(rs.getString(6));
			           listOfAppointment.add(app);
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
		 return  listOfAppointment;
	 }

}
