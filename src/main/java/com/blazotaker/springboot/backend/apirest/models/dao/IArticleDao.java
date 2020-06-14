package com.blazotaker.springboot.backend.apirest.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blazotaker.springboot.backend.apirest.models.entity.Article;

public interface IArticleDao extends JpaRepository<Article, Long> {

}
