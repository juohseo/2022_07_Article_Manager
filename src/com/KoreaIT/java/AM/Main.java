package com.KoreaIT.java.AM;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		System.out.println("==���α׷� ����==");
		
		Scanner sc = new Scanner(System.in);
		System.out.printf("��ɾ�) ");
		String command;
		command = sc.next();
		System.out.printf("�Էµ� ��ɾ� : %s\n", command);
		
		int num = sc.nextInt();
		System.out.printf("�Էµ� ���� : %d\n", num);
		
		sc.close();
		
		System.out.println("==���α׷� ��==");
		
	}

}
