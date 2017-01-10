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
		
		Board_Dao dao = new Board_Dao();
		ArrayList<Board_Dto> dtos = dao.boardList();
		request.setAttribute("list", dtos);
	}

}
