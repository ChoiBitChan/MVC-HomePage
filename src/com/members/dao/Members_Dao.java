package com.members.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.plaf.synth.SynthSeparatorUI;

import com.members.dto.Members_Dto;

public class Members_Dao {
	
	public static final int LOGIN_SUCCESS = 1;
	public static final int LOGIN_PW_FAIL = 0;
	public static final int LOGIN_FAIL = -1;
	
	public Members_Dao() {
		// TODO Auto-generated constructor stub
	}
	
	private static Members_Dao instance = new Members_Dao();
	
	public static Members_Dao getInstance() {
		return instance;
	}
	
	private Connection getConnection() {
		Connection connection = null;
		
		try {
			String driver = "oracle.jdbc.driver.OracleDriver";
	   	 	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	    	String uid = "scott";
	    	String upw = "tiger";
	    	
	    	Class.forName(driver);
			connection = DriverManager.getConnection(url, uid, upw);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return connection;
	}
	
	public void insertMember(String id, String pw, String name) {
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		
		try {
			connection = getConnection();
			String query = "insert into homepage_members (id, pw, name) values (?, ?, ?)";
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			int a = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public void updateInfo(String id, String pw, String name) {
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		
		try {
			connection = getConnection();
			String query = "update homepage_members set pw=?, name=? where id=?";
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, pw);
			pstmt.setString(2, name);
			pstmt.setString(3, id);
			int a = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public int userCheck(String id, String pw) {
		int N = 0;
		String checkPw;
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConnection();
			String query = "select pw from homepage_members where id = ?";
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, id);
			resultSet = pstmt.executeQuery();
			
			if(resultSet.next()) {
				checkPw = resultSet.getString("pw");
				if(checkPw.equals(pw)) {
					N = Members_Dao.LOGIN_SUCCESS;
					
				} else {
					N = Members_Dao.LOGIN_PW_FAIL;
				}
			} else {
				N = Members_Dao.LOGIN_FAIL;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				pstmt.close();
				connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return N;
	}
	
	public Members_Dto getInfo(String id) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		Members_Dto dto = null;
		
		try {
			connection = getConnection();
			String query = "select * from homepage_members where id = ?";
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, id);
			resultSet = pstmt.executeQuery();
			
			if(resultSet.next()) {
				dto = new Members_Dto();
				dto.setId(resultSet.getString("id"));
				dto.setPw(resultSet.getString("pw"));
				dto.setName(resultSet.getString("name"));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				pstmt.close();
				connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		if(dto == null)
		System.out.println("dto is null");
		return dto;
	}

}
