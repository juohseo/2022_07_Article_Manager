package com.KoreaIT.java.AM;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		System.out.println("==���α׷� ����==");

		Scanner sc = new Scanner(System.in);

		int lastArticleId = 0;

		List<Article> articles = new ArrayList<>();

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
				int id = lastArticleId + 1;
				lastArticleId = id;
				System.out.printf("���� : ");
				String title = sc.nextLine();
				System.out.printf("���� : ");
				String body = sc.nextLine();

				Article article = new Article(id, title, body);
				articles.add(article);

				System.out.printf("%d������ �����Ǿ����ϴ�\n", id);

			} else if (command.equals("article list")) {
				if (articles.size() == 0) {
					System.out.println("�Խñ��� �����ϴ�");
					continue;
				}
				System.out.println("��ȣ    |  ����");
				for (int i = articles.size() - 1; i >= 0; i--) {
					Article article = articles.get(i);

					System.out.printf("%d  	 |  %s\n", article.id, article.title);
				}
			} else {
				System.out.println("�������� �ʴ� ��ɾ� �Դϴ�");
			}
		}

		sc.close();

		System.out.println("==���α׷� ��==");
	}
}

class Article {
	int id;
	String title;
	String body;

	public Article(int id, String title, String body) {
		this.id = id;
		this.title = title;
		this.body = body;
	}
}