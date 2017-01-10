package com.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.Board_Dao;
import com.board.dto.Board_Dto;

public class B_Content_Command implements B_Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		String bNum = request.getParameter("bNum");
		Board_Dao dao = new Board_Dao();
		Board_Dto dto = dao.contentView(bNum);
		
		request.setAttribute("content_view", dto);
	}

}
