package com.ruda.controller;

import java.io.IOException;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NoticeContoller
 */
@WebServlet("/NoticeContoller")
public class NoticeContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeContoller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("NC");
		//String command = request.getParameter("command");
		
		String url = request.getServletPath();
		/*  문자열 뽑아오기 중간 noticeList와 NoticeSelect 뽑아오기
		 * System.out.println(url); String [] st = url.split("/"); url =
		 * st[2].substring(0,st[2].lastIndexOf(".")); System.out.println(url);
		 */
		url = url.substring(url.lastIndexOf("/")+1, url.lastIndexOf("."));
		System.out.println(url);
		
		StringBuffer rurl = request.getRequestURL();
		String uri = request.getRequestURI();
		
		//주소 뽑아오는 3가지 방법
		System.out.println(request.getServletPath());
		System.out.println(uri);
		System.out.println(rurl.toString());
		
		String path="";
		boolean flag =false;
		if(url.equals("noticeList")) {
			path="noticeList.jsp";
			request.setAttribute("board", "noticeList");
			flag = true;
		}else if(url.equals("noticeSelect")) {
			String check = request.getParameter("check");
			System.out.println(check);	
			// check 1이라면 select페이지로 이동 
			//아니라면 List로 이동
			if(check.equals("1")){
				path="noticeSelect.jsp";
				request.setAttribute("select", "noticeSelect");
				flag = true;
			}else {
				path="./noticeList.notice";
				
			}
		}
		if(flag) {
		RequestDispatcher view = request.getRequestDispatcher(path);
		view.forward(request, response);
		}else {
			response.sendRedirect(path);
		}
		
		
		/*
		 * String path = ""; if(command.equals("List")) { path="./noticeList.jsp";
		 * request.setAttribute("board", "notice"); }else { path="./noticeSelect.jsp"; }
		 * 
		 * RequestDispatcher view = request.getRequestDispatcher(path);
		 * view.forward(request, response);
		 */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
