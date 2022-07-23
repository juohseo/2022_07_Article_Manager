package com.KoreaIT.java.AM;

import java.util.*;

import com.KoreaIT.java.AM.controller.*;

public class App {

	public App() {
	}

	public void start() {
		System.out.println("==���α׷� ����==");

		Scanner sc = new Scanner(System.in);

		MemberController memberController = new MemberController(sc);
		ArticleController articleController = new ArticleController(sc);

		articleController.makeTestData();

		while (true) {
			System.out.printf("��ɾ� ) ");
			String command = sc.nextLine().trim();

			if (command.length() == 0) {
				System.out.println("��ɾ �Է����ּ���");
				continue;
			}

			if (command.equals("system exit")) {
				break;
			}

			String[] commandBits = command.split(" ");

			if (commandBits.length == 1) {
				System.out.println("�������� �ʴ� ��ɾ��Դϴ�.");
				continue;
			}

			String controllerName = commandBits[0];
			String actionMethodName = commandBits[1];

			Controller controller = null;

			if (controllerName.equals("article")) {
				controller = articleController;
			} else if (controllerName.equals("member")) {
				controller = memberController;
			} else {
				System.out.println("�������� �ʴ� ��ɾ��Դϴ�.");
				continue;
			}

			controller.doAction(command, actionMethodName);

		}

		sc.close();

		System.out.println("==���α׷� ��==");
	}

}