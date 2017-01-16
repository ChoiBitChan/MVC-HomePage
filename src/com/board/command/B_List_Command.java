package com.board.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.Board_Dao;
import com.board.dto.Board_Dto;

public class B_List_Command implements B_Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		int pageCnt = 10;
		int pageNum;
		
		Board_Dao Bdao = new Board_Dao();
		//1을 뽑아 -> 리스트10씩뽑는 DAO메소드 호출
		
		if (request.getParameter("pageNum") == null) {
			pageNum = 1;
		} else {
		pageNum = Integer.parseInt(request.getParameter("pageNum"));
		}
		System.out.println(pageNum + " 페이지");
		
		
		//ArrayList<Board_Dto> dtos = Bdao.boardList();
		//request.setAttribute("list", dtos);
		
		ArrayList<Board_Dto> Pdtos = Bdao.boardList_Page(pageNum, pageCnt);
		request.setAttribute("list", Pdtos);
		
		int lastPage = Bdao.maxPage(pageCnt);
		request.setAttribute("lastPage", lastPage);
		
		request.setAttribute("pageNum", pageNum);
		
	}
	

}
