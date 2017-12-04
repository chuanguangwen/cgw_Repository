package com.hjc.server;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HttpServer
 */
@WebServlet("/HttpServer")
public class HttpServer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HttpServer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("get method");
		String param1 = request.getParameter("param1");
		String param2 = request.getParameter("param2");
		System.out.println("param1=" + param1);
		System.out.println("param2=" + param2);
		response.getWriter().write("post method from server");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("pose method");
		String param1 = request.getParameter("param1");
		String param2 = request.getParameter("param2");
		System.out.println("param1=" + param1);
		System.out.println("param2=" + param2);
		response.getWriter().write("post method from server");
	}

}
