package com.KoreaIT.java.AM.dao;

import java.util.*;

import com.KoreaIT.java.AM.dto.*;

public class MemberDao extends Dao {
	public List<Member> members;

	public MemberDao() {
		members = new ArrayList<>();
	}

	public void add(Member member) {
		members.add(member);
		lastId++;
	}

	
}