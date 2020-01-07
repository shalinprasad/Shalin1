package com.keane.training.domain;

public class Admin {
int aid;
String aname;
String apass;
int iid;

public Admin(){
	
}
public Admin(int aid, String aname, String apass, int iid) {
	super();
	this.aid = aid;
	this.aname = aname;
	this.apass = apass;
	this.iid = iid;
}
public Admin(int aid) {
	super();
	this.aid = aid;
}
public Admin(int aid, String apass) {
	super();
	this.aid = aid;
	this.apass = apass;
}
public Admin(int aid, String aname, String apass) {
	super();
	this.aid = aid;
	this.aname = aname;
	this.apass = apass;
}
public int getAid() {
	return aid;
}
public void setAid(int aid) {
	this.aid = aid;
}
public String getAname() {
	return aname;
}
public void setAname(String aname) {
	this.aname = aname;
}
public String getApass() {
	return apass;
}
public void setApass(String apass) {
	this.apass = apass;
}
public int getIid() {
	return iid;
}
}