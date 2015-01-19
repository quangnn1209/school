package org.school.servlets;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Servlet implementation class Authentication
 */
public class Authentication extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;
	private HttpServletResponse response;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Authentication() {
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
		StringBuffer jb = new StringBuffer();
		String line = null;
		session = request.getSession();
		this.response = response;

		JSONObject jsonObject = null;
		try {
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null)
				jb.append(line);
		} catch (IOException e) { // report an error
			System.err.print("IO Exception reading http header");
		}
		if (!jb.toString().equals("")) {

			try {
				jsonObject = new JSONObject(jb.toString());
			} catch (JSONException je) {
				System.err.println("Failed to create json object");
			}

			String userName = jsonObject.getString("name");
			String password = jsonObject.getString("password");
			JSONObject loginResponse = new JSONObject();
			loginResponse.put("authenticated", false);

			if (userName.equals("") && password.equals("")) {
				loginResponse.put("authenticated", true);
				session.setAttribute("Authenticated", true);
				// session.setAttribute("Page", PageName.HOME);
			}
			response.setContentType("application/json");
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().write(loginResponse.toString());

		} else {
			if (request.getParameter("logout") != null) {
				this.logout();
			} else {
				String result = session.getAttribute("Authenticated") != null ? session.getAttribute("Authenticated").toString() : "logged out";
				if (result.equalsIgnoreCase("true")) {
					result = "<a href='Authentication?logout=true'>log out</a>";
				}
				response.setContentType("text/html");
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().write(result);
			}
		}
	}

	private void logout() {
		session.removeAttribute("Authenticated");
		session.removeAttribute("Page");
		session.removeAttribute("Module");
		session.removeAttribute("Fragment");
		session.removeAttribute("Agents");
		response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
		response.setHeader("Location", "index.jsp");
		try {
			response.sendRedirect("index.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
