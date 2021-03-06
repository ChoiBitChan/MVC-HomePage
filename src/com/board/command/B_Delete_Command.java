package com.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.dao.Board_Dao;

public class B_Delete_Command implements B_Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session;
		session = request.getSession();
		
		String id = (String)session.getAttribute("id"); 
		String writer = request.getParameter("bId");
		
		String bNum = request.getParameter("bNum");
		
		Board_Dao Bdao = new Board_Dao();
		Bdao.idCheck(id, writer);
		
		//System.out.println(writer);
		//System.out.println(bNum);
		
		if(Bdao.idCheck(id, writer) == 1) {
			try {
				System.out.println("삭제 가능");
				Bdao.contentDelete(bNum);
				response.sendRedirect("board_page.Bdo");
				return;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		} else if (Bdao.idCheck(id, writer) == 0) {
			try {
				System.out.println("삭제 불가능");
				response.sendRedirect("board_page.Bdo");
				return;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

}
