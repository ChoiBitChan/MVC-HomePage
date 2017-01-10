package com.board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.board.dto.Board_Dto;

public class Board_Dao {

	public Board_Dao() {
		// TODO Auto-generated constructor stub
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
	
	public ArrayList<Board_Dto> boardList() {
		ArrayList<Board_Dto> dtos = new ArrayList<Board_Dto>();
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			
			String query = "select bNum, bId, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent from Homepage_Board order by bGroup desc, bStep asc";
			pstmt = connection.prepareStatement(query);
			resultSet = pstmt.executeQuery();
			
			while (resultSet.next()) {
				int bNum = resultSet.getInt("bNum");
				String bId = resultSet.getString("bId");
				String bTitle = resultSet.getString("bTitle");
				String bContent = resultSet.getString("bContent");
				Timestamp bDate = resultSet.getTimestamp("bDate");
				int bHit = resultSet.getInt("bHit");
				int bGroup = resultSet.getInt("bGroup");
				int bStep = resultSet.getInt("bStep");
				int bIndent = resultSet.getInt("bIndent");
				
				Board_Dto dto = new Board_Dto(bNum, bId, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
				dtos.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) resultSet.close();
				if (pstmt != null) pstmt.close();
				if (connection != null) connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dtos;
	}
	
	public void write(String bId, String bTitle, String bContent) {
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		
		try {
			connection = getConnection();
			String query = "insert into Homepage_Board (bNum, bId, bTitle, bContent, bHit, bGroup, bStep, bIndent) values (mvc_board_seq.nextval, ?, ?, ?, 0, mvc_board_seq.currval, 0, 0)";
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, bId);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			int rn = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (connection != null) connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public Board_Dto contentView(String strID) {
		upHit(strID);
		
		Board_Dto dto = null;
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		
try {
			
			connection = getConnection();
			
			String query = "select * from Homepage_Board where bNum = ?";
			pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(strID));
			resultSet = pstmt.executeQuery();
			
			if(resultSet.next()) {
				int bNum = resultSet.getInt("bNum");
				String bId = resultSet.getString("bId");
				String bTitle = resultSet.getString("bTitle");
				String bContent = resultSet.getString("bContent");
				Timestamp bDate = resultSet.getTimestamp("bDate");
				int bHit = resultSet.getInt("bHit");
				int bGroup = resultSet.getInt("bGroup");
				int bStep = resultSet.getInt("bStep");
				int bIndent = resultSet.getInt("bIndent");
				
				dto = new Board_Dto(bNum, bId, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null) resultSet.close();
				if(pstmt != null) pstmt.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		
		return dto;
	}
	
	private void upHit(String bNum) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pstmt = null;
		
		try {
			connection = getConnection();
			String query = "update Homepage_Board set bHit = bHit + 1 where bNum = ?";
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, bNum);
			
			int rn = pstmt.executeUpdate();
					
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
	
	public void contentDelete(String bNum) {
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		
		try {
			
			connection = getConnection();
			String query = "delete from Homepage_Board where bNum = ?";
			pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(bNum));
			int rn = pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null ) pstmt.close();
				if (connection != null ) connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
}
