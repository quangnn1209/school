package org.school.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.school.common.ActionHelper;
import org.school.common.UserHelper;
import org.school.persisted.User;

/**
 * Servlet implementation class Controller
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;
	private RequestDispatcher requestDispatcher;
	private HttpServletRequest request;
	private HttpServletResponse response;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session = request.getSession();

		this.request = request;
		this.response = response;

		if ("login".equals(request.getParameter("action"))) {
			login();
		} else if ("signup".equals(request.getParameter("action"))) {
			signUp();
		} else if ("update".equals(request.getParameter("action"))) {
			update();
		} else if ("delete".equals(request.getParameter("action"))) {
			delete();
		} else {
			if (session.getAttribute("user") == null) {
				ActionHelper.redirectToAction(response, "AuthenticationServlet");
				return;
			}
			list();
		}
	}

	private void delete() {
		User user = new User(Long.parseLong(request.getParameter("id")));
		UserHelper.delete(user);
	}

	private void update() {
		User user = new User(Long.parseLong(request.getParameter("id")), request.getParameter("name"), Integer.parseInt(request.getParameter("role")),
				request.getParameter("code"), request.getParameter("email"));
		User dbUser = UserHelper.getPersistantObject(user);
		user.setPassword(dbUser.getPassword());
		UserHelper.saveOrUpdate(user);
	}

	private void signUp() {
		User user = new User(request.getParameter("name"), UserHelper.md5(request.getParameter("password")), 0, request.getParameter("code"),
				request.getParameter("email"));
		if (UserHelper.saveOrUpdate(user) > 0) {
			ActionHelper.forwardToPage(requestDispatcher, request, response, "home.jsp");
		} else {
			ActionHelper.forwardToPage(requestDispatcher, request, response, "index.jsp");
		}
	}

	private void login() {
		User user = new User(UserHelper.md5(request.getParameter("password")), request.getParameter("email"));
		user = UserHelper.doLogin(user);
		if (user != null) {
			session.setAttribute("user", user);
			ActionHelper.redirectToAction(response, "TimetableScheduleServlet");
		} else {
			ActionHelper.forwardToPage(requestDispatcher, request, response, "index.jsp");
		}
	}

	private void list() {
		request.setAttribute("userList", UserHelper.getAllUsers());
		ActionHelper.forwardToPage(requestDispatcher, request, response, "user.jsp");
	}
}
