package com.KoreaIT.java.AM.dao;

import java.util.*;

import com.KoreaIT.java.AM.dto.*;

public class ArticleDao extends Dao {
	public List<Article> articles;

	public ArticleDao() {
		articles = new ArrayList<>();
	}

	public void add(Article article) {
		articles.add(article);
		lastId++;
	}
}