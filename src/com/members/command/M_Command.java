package com.members.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface M_Command {

	void execute(HttpServletRequest request, HttpServletResponse response);
	
}
