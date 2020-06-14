package com.blazotaker.springboot.backend.apirest.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.sun.istack.NotNull;

@Entity
public class Article implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@NotNull
	@Column(length = 255)
	private String title;

	@NotNull
	private String imgBanner;

	@NotNull
	@Column(length = 4000)
	private String content;

	@NotNull
	private boolean isDeleted;

	@Column(name = "created_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

	@Column(name = "updated_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;
	
	@ManyToMany
	@JoinTable(name="articles_tags"
		,joinColumns=@JoinColumn(name="article_id")
		,inverseJoinColumns = @JoinColumn(name="tag_id")
	)
	private List<Tag> tags;
	
	public Article() {
		tags = new ArrayList<Tag>();
	}

	@PrePersist
	public void prePersist() {
		createdAt = new Date();
	}

	public Long getArticleId() {
		return Id;
	}

	public void Id(Long Id) {
		this.Id  = Id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	

	public String getImgBanner() {
		return imgBanner;
	}

	public void setImgBanner(String imgBanner) {
		this.imgBanner = imgBanner;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	
	public void addTag(Tag tag) {
		tags.add(tag);
	}



	private static final long serialVersionUID = 1L;

}
