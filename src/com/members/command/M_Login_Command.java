package com.members.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.members.dao.Members_Dao;

public class M_Login_Command implements M_Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		Members_Dao Mdao = new Members_Dao();
		
		
		if(Mdao.userCheck(id, pw) == 1) { // 성공
			try {
				
				System.out.println("성공");
				Mdao.getInfo(id);
				System.out.println("회원 정보 가져오기");
				System.out.println(id);
				
				HttpSession session = null;
				session = request.getSession();
				System.out.println("세션 생성");
				session.setAttribute("id", id);
				session.setAttribute("pw", pw);
				System.out.println(Mdao.getInfo(id).getName());
				session.setAttribute("name", Mdao.getInfo(id).getName());
				System.out.println("세션 세팅");
				response.sendRedirect("Page_main.jsp");
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if(Mdao.userCheck(id, pw) == 0) { // 비밀번호 불일치
			try {
				System.out.println("비밀번호 불일치");
				response.sendRedirect("Page_login.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if(Mdao.userCheck(id, pw) == -1) { // 회원정보 없음
			try {
				System.out.println("회원정보 없음");
				response.sendRedirect("Page_join.jsp");
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
