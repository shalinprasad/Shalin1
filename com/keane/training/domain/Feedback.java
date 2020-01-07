package com.keane.training.domain;

public class Feedback {
int cid;
int sid;
int iid;
String feedback;

public Feedback(int iid) {
	super();
	this.iid = iid;
}
public Feedback(){
	
}
public Feedback(int cid, int sid, int iid, String feedback) {
	super();
	this.cid = cid;
	this.sid = sid;
	this.iid = iid;
	this.feedback = feedback;
}
public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public int getIid() {
	return iid;
}
public void setIid(int iid) {
	this.iid = iid;
}
public int getSid() {
	return sid;
}
public void setSid(int sid) {
	this.sid = sid;
}
public String getFeedback() {
	return feedback;
}
public void setFeedback(String feedback) {
	this.feedback = feedback;
}


}
