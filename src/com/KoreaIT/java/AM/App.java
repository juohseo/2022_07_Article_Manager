package com.KoreaIT.java.AM;

import java.util.*;

import com.KoreaIT.java.AM.dto.*;
import com.KoreaIT.java.AM.util.*;

public class App {
	private List<Article> articles;

	public App() {
		articles = new ArrayList<>();
	}

	public void start() {
		System.out.println("==���α׷� ����==");

		makeTestData();

		Scanner sc = new Scanner(System.in);

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

			if (command.equals("article write")) {
				int id = articles.size() + 1;
				String regDate = Util.getNowDateStr();
				System.out.printf("���� : ");
				String title = sc.nextLine();
				System.out.printf("���� : ");
				String body = sc.nextLine();

				Article article = new Article(id, regDate, title, body);
				articles.add(article);

				System.out.printf("%d������ �����Ǿ����ϴ�\n", id);

			} else if (command.equals("article list")) {
				if (articles.size() == 0) {
					System.out.println("�Խñ��� �����ϴ�");
					continue;
				}
				System.out.println("��ȣ  |  ����  |  ��ȸ");
				for (int i = articles.size() - 1; i >= 0; i--) {
					Article article = articles.get(i);

					System.out.printf("%5d | %6s | %4d\n", article.id, article.title, article.hit);
				}
			} else if (command.startsWith("article detail ")) {

				String[] commandBits = command.split(" ");

				int id = Integer.parseInt(commandBits[2]);

				Article foundArticle = getArticleById(id);

				if (foundArticle == null) {
					System.out.printf("%d�� �Խù��� �������� �ʽ��ϴ�.\n", id);
					continue;
				}

				foundArticle.increaseHit();

				System.out.printf("��ȣ : %d\n", foundArticle.id);
				System.out.printf("��¥ : %s\n", foundArticle.regDate);
				System.out.printf("���� : %s\n", foundArticle.title);
				System.out.printf("���� : %s\n", foundArticle.body);
				System.out.printf("��ȸ : %d\n", foundArticle.hit);

			} else if (command.startsWith("article modify ")) {

				String[] commandBits = command.split(" ");

				int id = Integer.parseInt(commandBits[2]);

				Article foundArticle = getArticleById(id);

				if (foundArticle == null) {
					System.out.printf("%d�� �Խù��� �������� �ʽ��ϴ�.\n", id);
					continue;
				}
				System.out.printf("���� : ");
				String title = sc.nextLine();
				System.out.printf("���� : ");
				String body = sc.nextLine();

				foundArticle.title = title;
				foundArticle.body = body;

				System.out.printf("%d�� �Խù��� �����߽��ϴ�.\n", id);

			} else if (command.startsWith("article delete ")) {

				String[] commandBits = command.split(" ");

				int id = Integer.parseInt(commandBits[2]);

				int foundIndex = getArticleIndexById(id);

				if (foundIndex == -1) {
					System.out.printf("%d�� �Խù��� �������� �ʽ��ϴ�.\n", id);
					continue;
				}
				articles.remove(foundIndex);
				System.out.printf("%d�� �Խù��� �����߽��ϴ�.\n", id);

			} else {
				System.out.println("�������� �ʴ� ��ɾ� �Դϴ�");
			}
		}

		sc.close();

		System.out.println("==���α׷� ��==");
	}

	private int getArticleIndexById(int id) {
		int i = 0;
		for (Article article : articles) {

			if (article.id == id) {
				return i;
			}
			i++;
		}
		return -1;
	}

	private Article getArticleById(int id) {

//		for (int i = 0; i < articles.size(); i++) {
//			Article article = articles.get(i);
//
//			if (article.id == id) {
//				return article;
//			}
//		}

//		for (Article article : articles) {
//
//			if (article.id == id) {
//				return article;
//			}
//		}

		int index = getArticleIndexById(id);

		if (index != -1) {
			return articles.get(index);
		}

		return null;
	}

	private void makeTestData() {
		System.out.println("�׽�Ʈ�� ���� �����͸� �����մϴ�.");

		articles.add(new Article(1, Util.getNowDateStr(), "����1", "����1", 11));
		articles.add(new Article(2, Util.getNowDateStr(), "����2", "����2", 22));
		articles.add(new Article(3, Util.getNowDateStr(), "����3", "����3", 33));

	}
}