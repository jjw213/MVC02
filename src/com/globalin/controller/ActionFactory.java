package com.globalin.controller;

import com.globalin.controller.action.Action;
import com.globalin.controller.action.EmployeeListAction;
import com.globalin.controller.action.EmployeeViewAction;
import com.globalin.controller.action.EmployeeWriteAction;
import com.globalin.controller.action.EmployeeWriteFormAction;

public class ActionFactory {

	private static ActionFactory instance = new ActionFactory();

	private ActionFactory() {

	}

	public static ActionFactory getInstance() {
		return instance;
	}

	// �׼����丮 Ŭ������ ������
	// �Ķ���ͷ� �޾ƿ� command��ex)employee_list
	// command ���� ���� �ش� command�� ó������ Action ��ü�� �����ؼ� ��ȯ
	public Action getAction(String command) {
		Action action = null;
		System.out.println("Action:" + command);
		if (command.equals("employees_list")) {
			action = new EmployeeListAction();
		} else if (command.equals("employees_write_form")) {
			action = new EmployeeWriteFormAction();
		} else if (command.equals("employees_write")) {
			action = new EmployeeWriteAction();
		} else if (command.equals("employees_view")) {
			action = new EmployeeViewAction();
		}

		return action;
	}

}
