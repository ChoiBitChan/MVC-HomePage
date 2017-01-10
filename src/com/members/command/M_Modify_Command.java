package com.members.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.members.dao.Members_Dao;

public class M_Modify_Command implements M_Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		
		Members_Dao Mdao = new Members_Dao();
		Mdao.updateInfo(id, pw, name);
	}

}
