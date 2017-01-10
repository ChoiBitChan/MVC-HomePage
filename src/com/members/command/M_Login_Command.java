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
		
		
		if(Mdao.userCheck(id, pw) == 1) { // ����
			try {
				
				System.out.println("����");
				Mdao.getInfo(id);
				System.out.println("ȸ�� ���� ��������");
				System.out.println(id);
				
				HttpSession session = null;
				session = request.getSession();
				System.out.println("���� ����");
				session.setAttribute("id", id);
				session.setAttribute("pw", pw);
				System.out.println(Mdao.getInfo(id).getName());
				session.setAttribute("name", Mdao.getInfo(id).getName());
				System.out.println("���� ����");
				response.sendRedirect("Page_main.jsp");
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if(Mdao.userCheck(id, pw) == 0) { // ��й�ȣ ����ġ
			try {
				System.out.println("��й�ȣ ����ġ");
				response.sendRedirect("Page_login.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if(Mdao.userCheck(id, pw) == -1) { // ȸ������ ����
			try {
				System.out.println("ȸ������ ����");
				response.sendRedirect("Page_join.jsp");
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
