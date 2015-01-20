package org.school.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.school.common.ActionHelper;
import org.school.common.ClassHelper;
import org.school.common.ExamHelper;
import org.school.common.TimetableSchedulerHelper;
import org.school.common.Utils;
import org.school.persisted.Class;
import org.school.persisted.Exam;

/**
 * Servlet implementation class Controller
 */
public class TimetableScheduleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;
	private RequestDispatcher requestDispatcher;
	private HttpServletRequest request;
	private HttpServletResponse response;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TimetableScheduleServlet() {
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
		if (session.getAttribute("user") == null) {
			ActionHelper.redirectToAction(response, "AuthenticationServlet");
			return;
		}

		this.request = request;
		this.response = response;

		if ("add".equals(request.getParameter("action"))) {
			add();
		} else if ("delete".equals(request.getParameter("action"))) {
			delete();
		} else {
			getTsList();
		}
	}

	private void getTsList() {
		request.setAttribute("tsList", TimetableSchedulerHelper.getAllTs());
		ActionHelper.forwardToPage(requestDispatcher, request, response, "home.jsp");
	}

	private void add() {
		if ("1".equals(request.getParameter("titleType"))) {
			Class cl = new Class(Long.parseLong(request.getParameter("tsId")), request.getParameter("code"), Utils.millisecondToDate(request
					.getParameter("startTime")), Utils.millisecondToDate(request.getParameter("endTime")));
			ClassHelper.saveOrUpdate(cl);
		} else if ("0".equals(request.getParameter("titleType"))) {
			Exam ex = new Exam(Long.parseLong(request.getParameter("tsId")), request.getParameter("code"), Utils.millisecondToDate(request
					.getParameter("startTime")), Utils.millisecondToDate(request.getParameter("endTime")));
			ExamHelper.saveOrUpdate(ex);
		}
	}

	private void delete() {
		String idParam = request.getParameter("id");
		String titleType = idParam.split("-")[0];
		String id = idParam.split("-")[1];
		if ("class".equals(titleType)) {
			Class clazz = new Class(Long.parseLong(id));
			ClassHelper.delete(clazz);
		} else if ("exam".equals(titleType)) {
			Exam exam = new Exam(Long.parseLong(id));
			ExamHelper.delete(exam);
		}
	}
}