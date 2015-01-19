package org.school.common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ActionHelper {
	public static void forwardToPage(RequestDispatcher requestDispatcher, HttpServletRequest request, HttpServletResponse response, String page) {
		requestDispatcher = request.getRequestDispatcher("pages/" + page);
		try {
			requestDispatcher.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void redirectToAction(HttpServletResponse response, String action) {
		try {
			response.sendRedirect(action);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
