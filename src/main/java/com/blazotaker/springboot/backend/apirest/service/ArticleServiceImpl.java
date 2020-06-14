package com.blazotaker.springboot.backend.apirest.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blazotaker.springboot.backend.apirest.models.dao.IArticleDao;
import com.blazotaker.springboot.backend.apirest.models.entity.Article;

@Service
public class ArticleServiceImpl implements IArticleService{

	@Autowired
	private IArticleDao articleDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Article> findAll() {
		return (List<Article>)articleDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Article findById(Long id) {
		return articleDao.findById(id).orElse(null);
	}

	@Override
	public Article save(Article article) {
		return articleDao.save(article);
	}

	@Override
	public void deleteById(Long id) {
		articleDao.deleteById(id);		
	}

}
