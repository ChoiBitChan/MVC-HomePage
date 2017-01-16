package com.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.Board_Dao;

public class B_Reply_Command implements B_Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		System.out.println("B_Reply_Command");
		String bNum = request.getParameter("bNum");
		String bId = request.getParameter("bId");
		String bTitle = request.getParameter("bTitle");
		System.out.println(bTitle);
		String bContent = request.getParameter("bContent");
		String bGroup = request.getParameter("bGroup");
		String bStep = request.getParameter("bStep");
		String bIndent = request.getParameter("bIndent");
		
		Board_Dao Bdao = new Board_Dao();
		Bdao.reply(bNum, bId, bTitle, bContent, bGroup, bStep, bIndent);
	}

}
