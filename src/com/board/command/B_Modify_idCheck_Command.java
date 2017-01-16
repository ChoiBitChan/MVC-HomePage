package com.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.dao.Board_Dao;

public class B_Modify_idCheck_Command implements B_Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session;
		session = request.getSession();
		
		//System.out.println(session.getAttribute("id")); // 지금 아이디
		//System.out.println(request.getParameter("bId")); // 작성자 아이디
		
		String id = (String)session.getAttribute("id");
		String writer = request.getParameter("bId");
		
		Board_Dao Bdao = new Board_Dao();
		
		Bdao.idCheck(id, writer);
		
		if(Bdao.idCheck(id, writer) == 1) {
			try {
				System.out.println("일치");
				String bNum = request.getParameter("bNum");
				session.setAttribute("bNum", bNum);
				String bTitle = request.getParameter("bTitle");
				session.setAttribute("bTitle", bTitle);
				String bContent = request.getParameter("bContent");
				session.setAttribute("bContent", bContent);
				response.sendRedirect("Page_board_modify.jsp");
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		} else if (Bdao.idCheck(id, writer) == 0) {
			try {
				System.out.println("불일치");
				response.sendRedirect("board_page.Bdo");
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

}
