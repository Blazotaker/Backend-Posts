package com.blazotaker.springboot.backend.apirest.service;

import java.util.List;

import com.blazotaker.springboot.backend.apirest.models.entity.Article;

public interface IArticleService {

	public List<Article> findAll();
	
	public Article findById(Long id);
	
	public Article save(Article article);
	
	public void deleteById(Long id);
}
