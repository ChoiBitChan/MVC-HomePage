package com.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.Board_Dao;

public class B_Delete_Command implements B_Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String bNum = request.getParameter("bNum");
		Board_Dao dao = new Board_Dao();
		dao.contentDelete(bNum);
		
	}

}
