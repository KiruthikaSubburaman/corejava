package com.chainsys.miniproject.dao;

import com.chainsys.miniproject.pojo.Doctor;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DoctorDao {
	public static Connection getConnection() {
		String drivername = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user= "system";
		String pwd= "Nithikiru@1927";
		try {
			Class.forName(drivername);
		} catch (ClassNotFoundException e) {
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

	public static java.sql.Date convertToSqlDate(java.util.Date date)
    {
        java.sql.Date sqldate = new java.sql.Date(date.getTime());
        return sqldate;
    }
	public static int insertDoctor(Doctor newdoc)
    {
        String insertquery = "insert into Doctor(doctor_id,name,dob,speciality,city,phone_number,standard_fees) values (?,?,?,?,?,?,?)";
        Connection con = null;
        int rows = 0;
        PreparedStatement stmt = null;
        try {
            con = getConnection();
            stmt = con.prepareStatement(insertquery);
            stmt.setInt(1,newdoc.getDoctor_id());
            stmt.setString(2,newdoc.getName());
            stmt.setDate(3, convertToSqlDate(newdoc.getDob()));
            stmt.setString(4, newdoc.getSpeciality());
            stmt.setString(5,newdoc.getCity());
            stmt.setLong(6,newdoc.getPhone_number());
            stmt.setFloat(7,newdoc.getStandard_fees());
            rows=stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
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
        return rows;
    }
	public static int updateDoctor(Doctor newdoc) {
		String updatequery = "update Doctor set name=?,dob=?,speciality=?,city=?,phone_number=?,standard_fees=? where doctor_id=?";
		Connection con = null;
		int rows = 0;
		PreparedStatement stmt = null;
		try {
			con = getConnection();
			stmt = con.prepareStatement(updatequery);
			stmt.setInt(7, newdoc.getDoctor_id());
			stmt.setString(1, newdoc.getName());
			stmt.setLong(5, newdoc.getPhone_number());
			stmt.setString(3, newdoc.getSpeciality());
			stmt.setDate(2, convertToSqlDate(newdoc.getDob()));
			stmt.setString(4, newdoc.getCity());
			stmt.setFloat(6, newdoc.getStandard_fees());

			stmt.executeUpdate();
			rows = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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

		return rows;
	}

	public static int updateDoctorName(int id, String fname) {
		String updatequery = "update Doctor set name=? where doctor_id=?";
		Connection con = null;
		int rows = 0;
		PreparedStatement stmt = null;
		try {
			con = getConnection();
			stmt = con.prepareStatement(updatequery);
			stmt.setString(1, fname);
			stmt.setInt(2, id);
			stmt.executeUpdate();
			rows = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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

		return rows;
	}

	public static int updateDoctorStandard_fees(int id, float standard_fees) {
		String updatequery = "update Doctor set standard_fees=? where doctor_id=?";
		Connection con = null;
		int rows = 0;
		PreparedStatement stmt = null;
		try {
			con = getConnection();
			stmt = con.prepareStatement(updatequery);
			stmt.setFloat(1, standard_fees);
			stmt.setInt(2, id);
			stmt.executeUpdate();
			rows = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
		return rows;
	}

	public static int deleteDoctor(int id) {
		String deletequery = ("delete from Doctor where doctor_id=?");
		Connection con = null;
		int rows = 0;
		PreparedStatement stmt = null;

		try {
			con = getConnection();
			stmt = con.prepareStatement(deletequery);
			stmt.setInt(1, id);
			rows = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
		return rows;
	}

	
	public static Doctor getDoctorByDoctor_Id(int id) {
		Doctor doc= new Doctor();
		String selectquery = "select doctor_id,name,dob,speciality,city,phone_number,standard_fees from Doctor where doctor_id = ? ";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			stmt = con.prepareStatement(selectquery);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			if (rs.next()) {
				doc.setDoctor_id(rs.getInt(1));
				doc.setName(rs.getString(2));
				java.util.Date date = new java.util.Date(rs.getDate(3).getTime());
				doc.setDob(date);
				doc.setSpeciality(rs.getString(4));
				doc.setCity(rs.getString(5));
				doc.setPhone_number(rs.getLong(6));
				doc.setStandard_fees(rs.getFloat(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
		return doc;

	}
	public static List<Doctor> getAllDoctor() {
		List<Doctor> listOfDoctor = new ArrayList<Doctor>();
		Doctor doc = null;
		String selectquery = "select doctor_id,name,dob,speciality,city,phone_number,standard_fees  from Doctor ";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			stmt = con.prepareStatement(selectquery);
			rs = stmt.executeQuery();
		while (rs.next()) {
			doc = new Doctor();
				doc.setDoctor_id(rs.getInt(1));
				doc.setName(rs.getString(2));
				java.util.Date date = new java.util.Date(rs.getDate(3).getTime());
				doc.setDob(date);
				doc.setSpeciality(rs.getString(4));
				doc.setCity(rs.getString(5));
				doc.setPhone_number(rs.getLong(6));
				doc.setStandard_fees(rs.getFloat(7));
				listOfDoctor.add(doc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
		return listOfDoctor;
	}
}