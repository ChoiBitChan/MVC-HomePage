package com.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.Board_Dao;


public class B_Write_Command implements B_Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String bId = request.getParameter("bId");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		
		Board_Dao dao = new Board_Dao();
		dao.write(bId, bTitle, bContent);
	}

}
