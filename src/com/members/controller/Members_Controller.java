package com.members.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.members.command.M_Command;
import com.members.command.M_Join_Command;
import com.members.command.M_Login_Command;
import com.members.command.M_Modify_Command;

/**
 * Servlet implementation class Members_Controller
 */
@WebServlet("*.Mdo")
public class Members_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Members_Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		
		String viewPage = null;
		M_Command Mcommand = null;
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		
		if (com.equals("/main_page.Mdo")) { // ���� ������ ����
			viewPage = "Page_main.jsp";
			System.out.println("���� ������ ����");
			
		} else if (com.equals("/login_page.Mdo")) { // �α��� ������ ����
			viewPage = "Page_login.jsp";
			System.out.println("�α��� ������ ����");
		} else if (com.equals("/login.Mdo")) {
			Mcommand = new M_Login_Command();
			Mcommand.execute(request, response);
			return;
		} 
		
		else if (com.equals("/join_page.Mdo")) { // ȸ������ ������ ����
			viewPage = "Page_join.jsp";
			System.out.println("ȸ������ ������ ����");
		} else if (com.equals("/join.Mdo")) {
			Mcommand = new M_Join_Command();
			Mcommand.execute(request, response);
			viewPage = "Page_login.jsp";
		} 
		
		else if (com.equals("/modify_page.Mdo")) { // �������� ������ ����
			System.out.println("�������� ������ ����");
			viewPage = "Page_modify.jsp";
		} else if (com.equals("/modify.Mdo")) {
			Mcommand = new M_Modify_Command();
			Mcommand.execute(request, response);
			viewPage = "Page_main.jsp";
		}
		
		else if (com.equals("/board_page.Mdo")) { // �Խ��� ������ ����
			System.out.println("�Խ��� ������ ����");
			viewPage = "board_page.Bdo";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}
