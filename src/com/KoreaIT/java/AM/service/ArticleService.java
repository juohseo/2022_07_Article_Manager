package com.KoreaIT.java.AM.service;

import java.util.*;

import com.KoreaIT.java.AM.container.*;
import com.KoreaIT.java.AM.dao.*;
import com.KoreaIT.java.AM.dto.*;

public class ArticleService {

	private ArticleDao articleDao;

	public ArticleService() {
		this.articleDao = Container.articleDao;
	}

	public List<Article> getForPrintArticles(String searchKeyword) {

		return articleDao.getArticles(searchKeyword);
	}

	public Article getArticleById(int id) {
		return articleDao.getArticleById(id);
	}

	public void add(Article article) {
		articleDao.add(article);
	}

	public void remove(Article foundArticle) {
		articleDao.remove(foundArticle);

	}

}