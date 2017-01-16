package com.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.command.B_Command;
import com.board.command.B_Content_Command;
import com.board.command.B_Delete_Command;
import com.board.command.B_List_Command;
import com.board.command.B_Modify_Command;
import com.board.command.B_Modify_idCheck_Command;
import com.board.command.B_Reply_Command;
import com.board.command.B_Reply_getInfo_Command;
import com.board.command.B_Write_Command;

/**
 * Servlet implementation class Board_Controller
 */
@WebServlet("*.Bdo")
public class Board_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Board_Controller() {
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
		B_Command command = null;
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		
		if (com.equals("/board_page.Bdo")) {
			command = new B_List_Command();
			command.execute(request, response);
			viewPage = "Page_board.jsp";
		}
		
		else if (com.equals("/write_page.Bdo")) {
			viewPage = "Page_write.jsp";
		} else if (com.equals("/write.Bdo")) {
			command = new B_Write_Command();
			command.execute(request, response);
			viewPage = "board_page.Bdo";
		}
		
		else if (com.equals("/content_page.Bdo")) {
			command = new B_Content_Command();
			command.execute(request, response);
			viewPage = "Page_content.jsp";
		}
		
		else if (com.equals("/delete.Bdo"))	{
			command = new B_Delete_Command();
			command.execute(request, response);
			return;
			//viewPage = "board_page.Bdo";
		}
		
		else if (com.equals("/board_modify_page.Bdo")) {
			command = new B_Modify_idCheck_Command();
			command.execute(request, response);
			return;
		} else if (com.equals("/board_modify.Bdo")) {
			command = new B_Modify_Command();
			command.execute(request, response);
			viewPage = "board_page.Bdo";
		}
		
		else if (com.equals("/board_reply_page.Bdo")) {
			command = new B_Reply_getInfo_Command();
			command.execute(request, response);
			viewPage = "Page_board_reply.jsp";
		} else if (com.equals("/reply.Bdo")) {
			System.out.println("reply.Bdo");
			command = new B_Reply_Command();
			command.execute(request, response);
			viewPage = "board_page.Bdo";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}
