package com.keane.training.domain;

public class Article {
int aid;
int iid;
String article;
public Article(){
	
}
public Article(int aid, int iid, String article) {
	super();
	this.aid=aid;
	this.iid = iid;
	this.article = article;
}

public int getAid() {
	return aid;
}

public void setAid(int aid) {
	this.aid = aid;
}

public int getIid() {
	return iid;
}
public void setIid(int iid) {
	this.iid = iid;
}
public String getArticle() {
	return article;
}
public void setArticle(String article) {
	this.article = article;
}

}
