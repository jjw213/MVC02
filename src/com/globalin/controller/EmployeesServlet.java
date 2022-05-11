package com.globalin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.globalin.controller.action.Action;

@WebServlet("/employee")
public class EmployeesServlet extends HttpServlet  {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doAction(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doAction(req, resp);
	}

	protected void doAction(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//command파라미터 가져오기
		String command = req.getParameter("command");
		System.out.println(command);
		//요청을 처리해줄 action객체를 만들어서 실행하기
		//1.action 팩토리 만들기
		ActionFactory af = ActionFactory.getInstance();
		//2.action팩토리의 getAction(command)메소드 호출해서
		//command에 맞는 action객체생성
		Action action = af.getAction(command);
		//3.action객체의 excute()메소드 실행
		
		if(action != null) {
			action.execute(req, resp);
		}
	}


}
