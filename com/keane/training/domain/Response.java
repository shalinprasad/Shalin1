package com.keane.training.domain;

public class Response {
int iid;
int sid1;
String response;
public Response(){
	
}
public Response(int iid, int sid1, String response) {
	super();
	this.iid = iid;
	this.sid1 = sid1;
	this.response = response;
}
public int getIid() {
	return iid;
}
public void setIid(int iid) {
	this.iid = iid;
}
public int getSid1() {
	return sid1;
}
public void setSid1(int sid1) {
	this.sid1 = sid1;
}
public String getResponse() {
	return response;
}
public void setRes(String response) {
	this.response = response;
}

}
