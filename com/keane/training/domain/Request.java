package com.keane.training.domain;

public class Request {
int cid;
int sid;
int iid;
String feedback;
String request;
String res;

public Request(int sid, int iid, String res) {
	super();
	this.sid = sid;
	this.iid = iid;
	this.res = res;
}

public Request(int cid, int sid, int iid, String request) {
	super();
	this.cid = cid;
	this.sid = sid;
	this.iid = iid;
	this.request = request;
}

public Request(int sid, String feedback) {
	super();
	this.sid = sid;
	this.feedback = feedback;
}
public Request(){
	
}
public Request(String res) {
	super();
	this.res = res;
}

public Request(int cid, int sid, int iid, String feedback, String request,
		String res) {
	super();
	this.cid = cid;
	this.sid = sid;
	this.iid = iid;
	this.feedback = feedback;
	this.request = request;
	this.res = res;
}
public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public int getSid() {
	return sid;
}
public void setSid(int sid) {
	this.sid = sid;
}
public int getIid() {
	return iid;
}
public void setIid(int iid) {
	this.iid = iid;
}
public String getFeedback() {
	return feedback;
}
public void setFeedback(String feedback) {
	this.feedback = feedback;
}
public String getComplaint() {
	return request;
}
public void setRequest(String request) {
	this.request = request;
}
public String getRes() {
	return res;
}
public void setRes(String res) {
	this.res = res;
}
@Override
public String toString() {
	// TODO Auto-generated method stub
	return "Complaint[cid="+cid+",sid="+sid+",iid="+iid+",feedback="+feedback+",complaint="+request+"]";
}


}
