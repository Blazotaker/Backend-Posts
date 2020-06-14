package com.blazotaker.springboot.backend.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blazotaker.springboot.backend.apirest.models.entity.Article;
import com.blazotaker.springboot.backend.apirest.service.IArticleService;

@CrossOrigin(origins  = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ArticleRestController {

	@Autowired
	private IArticleService articleService; 
	
	@GetMapping("/articles")
	public List<Article> index(){
		return articleService.findAll();
	}
	
}
