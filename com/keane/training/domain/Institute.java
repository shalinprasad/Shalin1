package com.keane.training.domain;

public class Institute {
int iid;
String iname;
String affdate;
String iaddr;
int iseats;
int icourse;
String ipass;
int status;
int sid;

//public Institute(int iid, int status) {
//	super();
//	this.iid = iid;
//	this.status = status;
//}
public Institute(){
	
}
public Institute(int iid, int sid) {
	super();
	this.iid = iid;
	this.sid = sid;
}
public Institute(String iname, String ipass) {
	super();
	this.iname = iname;
	this.ipass = ipass;
}
public Institute(int iid, String iname, String affdate, String iaddr,
		int iseats, int icourse, String ipass) {
	super();
	this.iid = iid;
	this.iname = iname;
	this.affdate = affdate;
	this.iaddr = iaddr;
	this.iseats = iseats;
	this.icourse = icourse;
	this.ipass = ipass;
}
public Institute(int iid, String iname, String affdate, String iaddr,
		int iseats, int icourse,String ipass,int status) {
	super();
	this.iid = iid;
	this.iname = iname;
	this.affdate = affdate;
	this.iaddr = iaddr;
	this.iseats = iseats;
	this.icourse = icourse;
	this.ipass=ipass;
	this.status=status;
}
public int getIid() {
	return iid;
}
public void setIid(int iid) {
	this.iid = iid;
}
public String getIname() {
	return iname;
}
public void setIname(String iname) {
	this.iname = iname;
}
public String getAffdate() {
	return affdate;
}
public void setAffdate(String affdate) {
	this.affdate = affdate;
}
public String getIaddr() {
	return iaddr;
}
public void setIaddr(String iaddr) {
	this.iaddr = iaddr;
}
public int getIseats() {
	return iseats;
}
public void setIseats(int iseats) {
	this.iseats = iseats;
}
public int getIcourse() {
	return icourse;
}
public void setIcourse(int icourse) {
	this.icourse = icourse;
}
public String getIpass() {
	return ipass;
}
public void setIpass(String ipass) {
	this.ipass = ipass;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}

public int getSid() {
	return sid;
}
public void setSid(int sid) {
	this.sid = sid;
}
@Override
public String toString() {
	// TODO Auto-generated method stub
	return "Institute[institute_id="+iid+",institute_name="+iname+",affdate="+affdate+
	",no_of_seats="+iseats+",no_of_course="+icourse+"]";
}

}
