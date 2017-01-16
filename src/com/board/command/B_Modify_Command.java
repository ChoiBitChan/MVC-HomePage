package com.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.Board_Dao;

public class B_Modify_Command implements B_Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String bNum = request.getParameter("bNum");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		
		Board_Dao Bdao = new Board_Dao();
		Bdao.contentModify(bNum, bTitle, bContent);
	}

}
