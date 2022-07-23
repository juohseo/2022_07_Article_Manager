package com.KoreaIT.java.AM;

import java.util.*;

import com.KoreaIT.java.AM.controller.*;
import com.KoreaIT.java.AM.dto.*;
import com.KoreaIT.java.AM.util.*;

public class App {
	private List<Article> articles;
	private List<Member> members;

	public App() {
		articles = new ArrayList<>();
		members = new ArrayList<>();
	}

	public void start() {
		System.out.println("==���α׷� ����==");

		makeTestData();

		Scanner sc = new Scanner(System.in);

		MemberController memberController = new MemberController(sc, members);
		ArticleController articleController = new ArticleController(sc, articles);

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

			String[] commandBits = command.split(" "); // article list

			if (commandBits.length == 1) {
				System.out.println("�������� �ʴ� ��ɾ��Դϴ�.");
				continue;
			}

			String controllerName = commandBits[0]; // article
			String actionMethodName = commandBits[1]; // list

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

//			if (command.equals("member join")) {
//				memberController.doJoin();
//			} else if (command.equals("article write")) {
//				articleController.doWrite();
//			} else if (command.startsWith("article list")) {
//				articleController.showList(command);
//			} else if (command.startsWith("article detail ")) {
//				articleController.showDetail(command);
//			} else if (command.startsWith("article modify ")) {
//				articleController.doModify(command);
//			} else if (command.startsWith("article delete ")) {
//				articleController.doDelete(command);
//			} else {
//				System.out.println("�������� �ʴ� ��ɾ� �Դϴ�");
//			}
		}

		sc.close();

		System.out.println("==���α׷� ��==");
	}

	private void makeTestData() {
		System.out.println("�׽�Ʈ�� ���� �����͸� �����մϴ�.");

		articles.add(new Article(1, Util.getNowDateStr(), "����1", "����1", 11));
		articles.add(new Article(2, Util.getNowDateStr(), "����2", "����2", 22));
		articles.add(new Article(3, Util.getNowDateStr(), "����3", "����3", 33));
	}
}