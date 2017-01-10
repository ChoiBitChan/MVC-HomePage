package com.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface B_Command {

	void execute(HttpServletRequest request, HttpServletResponse response);
	
}
