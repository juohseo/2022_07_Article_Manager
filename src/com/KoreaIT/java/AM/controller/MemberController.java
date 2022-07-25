package com.KoreaIT.java.AM.controller;

import java.util.*;

import com.KoreaIT.java.AM.container.*;
import com.KoreaIT.java.AM.dto.*;
import com.KoreaIT.java.AM.util.*;

public class MemberController extends Controller {
	private Scanner sc;
	private List<Member> members;
	private String command;
	private String actionMethodName;

	public MemberController(Scanner sc) {
		this.sc = sc;

		members = Container.memberDao.members;
	}

	public void doAction(String command, String actionMethodName) {
		this.command = command;
		this.actionMethodName = actionMethodName;

		switch (actionMethodName) {
		case "join":
			doJoin();
			break;
		case "login":
			doLogin();
			break;
		case "logout":
			doLogout();
			break;
		default:
			System.out.println("�������� �ʴ� ��ɾ��Դϴ�.");
			break;
		}
	}

	private void doLogout() {

		loginedMember = null;
		System.out.println("�α׾ƿ� �Ǿ����ϴ�.");
	}

	private void doLogin() {

		System.out.printf("�α��� ���̵� : ");
		String loginId = sc.nextLine();
		System.out.printf("�α��� ��й�ȣ : ");
		String loginPw = sc.nextLine();

		Member member = getMemberByLoginId(loginId);

		if (member == null) {
			System.out.println("�ش� ȸ���� �������� �ʽ��ϴ�.");
			return;
		}

		if (member.loginPw.equals(loginPw) == false) {
			System.out.println("��й�ȣ�� Ȯ�����ּ���.");
			return;
		}

		loginedMember = member;
		System.out.printf("�α��� ����!, %s�� ȯ���մϴ�.\n", loginedMember.name);
	}

	public void makeTestData() {
		System.out.println("�׽�Ʈ�� ���� ȸ�� �����͸� �����մϴ�.");

		Container.memberDao
				.add(new Member(Container.memberDao.getNewId(), Util.getNowDateStr(), "admin", "admin", "������"));
		Container.memberDao
				.add(new Member(Container.memberDao.getNewId(), Util.getNowDateStr(), "test1", "test1", "��ö��"));
		Container.memberDao
				.add(new Member(Container.memberDao.getNewId(), Util.getNowDateStr(), "test2", "test2", "�迵��"));
	}

	private Member getMemberByLoginId(String loginId) {
		int index = getMemberIndexByLoginId(loginId);

		if (index == -1) {
			return null;
		}

		return members.get(index);
	}

	private void doJoin() {
		int id = Container.memberDao.getNewId();
		String regDate = Util.getNowDateStr();

		String loginId = null;

		while (true) {
			System.out.printf("�α��� ���̵� : ");
			loginId = sc.nextLine();

			if (isJoinableLoginId(loginId) == false) {
				System.out.printf("%s��(��) �̹� ������� ���̵��Դϴ�.\n", loginId);
				continue;
			}

			break;
		}

		String loginPw = null;
		String loginPwConfirm = null;

		while (true) {
			System.out.printf("�α��� ��й�ȣ : ");
			loginPw = sc.nextLine();
			System.out.printf("�α��� ��й�ȣ Ȯ��: ");
			loginPwConfirm = sc.nextLine();

			if (loginPw.equals(loginPwConfirm) == false) {
				System.out.println("��й�ȣ�� �ٽ� �Է����ּ���");
				continue;
			}

			break;
		}

		System.out.printf("�̸� : ");
		String name = sc.nextLine();

		Member member = new Member(id, regDate, loginId, loginPw, name);
		Container.memberDao.add(member);

		System.out.printf("%d�� ȸ���� �����Ͽ����ϴ�\n", id);

	}

	private boolean isJoinableLoginId(String loginId) {
		int index = getMemberIndexByLoginId(loginId);

		if (index == -1) {
			return true;
		}

		return false;
	}

	private int getMemberIndexByLoginId(String loginId) {
		int i = 0;
		for (Member member : members) {
			if (member.loginId.equals(loginId)) {
				return i;
			}
			i++;
		}

		return -1;
	}

}