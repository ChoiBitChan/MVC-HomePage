package com.board.command;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.Board_Dao;

public class B_Reply_getInfo_Command implements B_Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String bNum = request.getParameter("bNum");
		System.out.println(bNum);
		
		Board_Dao Bdao = new Board_Dao();
		Bdao.getBoardInfo(bNum);
		
		try {
			String bId = Bdao.getBoardInfo(bNum).getbId();
			String bTitle = Bdao.getBoardInfo(bNum).getbTitle();
			String bContent = Bdao.getBoardInfo(bNum).getbContent();
			Timestamp bDate = Bdao.getBoardInfo(bNum).getbDate();
			int bHit = Bdao.getBoardInfo(bNum).getbHit();
			int bGroup = Bdao.getBoardInfo(bNum).getbGroup();
			int bStep = Bdao.getBoardInfo(bNum).getbStep();
			int bIndent = Bdao.getBoardInfo(bNum).getbIndent();
			request.setAttribute("bId", bId);
			request.setAttribute("bTitle", bTitle);
			request.setAttribute("bContent", bContent);
			request.setAttribute("bHit", bHit);
			request.setAttribute("bGroup", bGroup);
			request.setAttribute("bStep", bStep);
			request.setAttribute("bIndent", bIndent);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
