package com.board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.board.dto.Board_Dto;

public class Board_Dao {
	
	public static final int ID_MATCH = 1;
	public static final int ID_MISMATCH = 0;

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
		ArrayList<Board_Dto> Bdtos = new ArrayList<Board_Dto>();
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			
			//String query = "select bNum, bId, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent from homepage_board order by bGroup desc, bStep asc";
			String query = "select T.* from (select rownum as rNum, V.* from (select bNum, bId, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent from homepage_board order by bGroup desc, bStep asc) V) T where T.rNum between 1 and 20";
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
				
				Board_Dto Bdto = new Board_Dto(bNum, bId, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
				Bdtos.add(Bdto);
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
		return Bdtos;
	}
	
	public ArrayList<Board_Dto> boardList_Page(int pageNum, int pageCnt) {
		ArrayList<Board_Dto> Bdtos = new ArrayList<Board_Dto>();
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
	
		int first = ((pageNum-1)*pageCnt)+1;
		int last = pageNum * pageCnt;	
		
		try {
			connection = getConnection();
			
			String query = "select T.* from (select rownum as rNum, V.* from (select bNum, bId, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent from homepage_board order by bGroup desc, bStep asc) V) T where T.rNum between ? and ?";
			pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, first);
			pstmt.setInt(2, last);
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
				
				Board_Dto Bdto = new Board_Dto(bNum, bId, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
				Bdtos.add(Bdto);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}  finally {
			try {
				if (resultSet != null) resultSet.close();
				if (pstmt != null) pstmt.close();
				if (connection != null) connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return Bdtos;
	}
	
	public int rNum() {
		// TODO Auto-generated method stub
		int N = 0;
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConnection();
			String query = "select count(T.rNum) from (select rownum as rNum, V.* from (select bNum, bId, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent from homepage_board order by bGroup desc, bStep asc) V) T";
			pstmt = connection.prepareStatement(query);
			resultSet = pstmt.executeQuery();
			
			while(resultSet.next()) {
				N = resultSet.getInt("count(T.rNum)");
			}
					
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
		System.out.println("rNum : " + N);
		return N;
	}
	
	public int maxPage(int pageCnt) {
		int Cnt = 0;
		boolean check = true;
		
		int rNum = rNum();
				
		while(check) {
			if (rNum >= pageCnt){
				rNum = rNum - pageCnt;
				Cnt++;
			} else if(rNum == 0){
				check = false;
			} else if (rNum < pageCnt){
				Cnt++;
				check = false;
			} 
		}
		
		return Cnt;
	}
	
	public void write(String bId, String bTitle, String bContent) {
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		
		try {
			connection = getConnection();
			String query = "insert into homepage_board (bNum, bId, bTitle, bContent, bHit, bGroup, bStep, bIndent) values (homepage_board_seq.nextval, ?, ?, ?, 0, homepage_board_seq.currval, 0, 0)";
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
			
			String query = "select * from homepage_board where bNum = ?";
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
			String query = "update homepage_board set bHit = bHit + 1 where bNum = ?";
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
			String query = "delete from homepage_board where bNum = ?";
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
	
	public void contentModify(String bNum, String bTitle, String bContent) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		
		try {
			connection = getConnection();
			String query = "update homepage_board set bTitle = ?, bContent = ? where bNum = ?";
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, bTitle);
			pstmt.setString(2, bContent);
			pstmt.setString(3, bNum);
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
	
	public int idCheck(String id, String writer) {
		int N = 0;
		
		if(id.equals(writer)) {
			N = Board_Dao.ID_MATCH;
		} else {
			N = Board_Dao.ID_MISMATCH;
		}
		return N;
	}
	
	public Board_Dto getBoardInfo(String bNum) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		Board_Dto Bdto = null;
		
		try {
			connection = getConnection();
			String query = "select * from homepage_board where bNum = ?";
			pstmt = connection.prepareStatement(query);
			pstmt.setString(1, bNum);
			resultSet = pstmt.executeQuery();
			
			if(resultSet.next()) {
				Bdto = new Board_Dto();
				Bdto.setbId(resultSet.getString("bId"));
				Bdto.setbTitle(resultSet.getString("bTitle"));
				Bdto.setbContent(resultSet.getString("bContent"));
				Bdto.setbDate(resultSet.getTimestamp("bDate"));
				Bdto.setbHit(resultSet.getInt("bHit"));
				Bdto.setbGroup(resultSet.getInt("bGroup"));
				Bdto.setbStep(resultSet.getInt("bStep"));
				Bdto.setbIndent(resultSet.getInt("bIndent"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if ( pstmt != null ) pstmt.close();
				if ( connection != null ) connection.close();
				
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return Bdto;
	}
	
	public void reply(String bNum, String bId, String bTitle, String bContent, String bGroup, String bStep, String bIndent) {
		
		replyShape(bGroup, bStep);
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		
		try {
			connection = getConnection();
			String query = "insert into homepage_board (bNum, bId, bTitle, bContent, bGroup, bStep, bIndent) values (homepage_board_seq.nextval, ?, ?, ?, ?, ?, ?)";
			pstmt = connection.prepareStatement(query);
			
			pstmt.setString(1, bId);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			pstmt.setInt(4, Integer.parseInt(bGroup));
			pstmt.setInt(5, Integer.parseInt(bStep) + 1);
			pstmt.setInt(6, Integer.parseInt(bIndent) + 1);
			
			int rn = pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				 if (pstmt != null) pstmt.close();
				 if (connection != null) connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
	
	private void replyShape(String strGroup, String strStep) {
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		
		try {
			connection = getConnection();
			String query = "update homepage_board set bStep = bStep + 1 where bGroup = ? and bStep > ?";
			pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(strGroup));
			pstmt.setInt(2, Integer.parseInt(strStep));
			
			int rn = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if ( pstmt != null ) pstmt.close();
				if ( connection != null ) connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
}
