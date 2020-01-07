package com.keane.training.domain;

public class Faculty {
int fid;
String fname;
String dept;
int iid;
public Faculty(){
	
}
public Faculty(int fid, String fname, String dept,int iid) {
	super();
	this.fid = fid;
	this.fname = fname;
	this.dept = dept;
	this.iid=iid;
}
public int getFid() {
	return fid;
}
public void setFid(int fid) {
	this.fid = fid;
}
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public String getDept() {
	return dept;
}
public void setDept(String dept) {
	this.dept = dept;
}

public int getIid() {
	return iid;
}
public void setIid(int iid) {
	this.iid = iid;
}
@Override
public String toString() {
	// TODO Auto-generated method stub
return "Faculty[faculty_id="+fid+",faculty_name="+fname+"," +
		"faculty_dept="+dept+",iid="+iid+"]";
}

}
