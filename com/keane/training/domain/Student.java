package com.keane.training.domain;

public class Student {
int sid;
String sname;
String squal;
String scontact;
String saddr;
String semail;
String spass;
String status;
int iid;
public Student(){
	
}
public Student(int sid, String sname, String squal, String contact, String saddr,
		String semail, String spass) {
	super();
	this.sid = sid;
	this.sname = sname;
	this.squal = squal;
	this.scontact = contact;
	this.saddr = saddr;
	this.semail = semail;
	this.spass = spass;
}

public Student(String sname, String squal, String contact, String saddr,
		String semail,String spass) {
	super();
	this.sname = sname;
	this.squal = squal;
	this.scontact = contact;
	this.saddr = saddr;
	this.semail = semail;
	this.spass=spass;
}

public Student(int sid, String spass) {
	super();
	this.sid = sid;
	this.spass = spass;
}

public Student(int sid, String sname, String squal, String contact, String saddr,
		String semail, String spass,int iid) {
	super();
	this.sid = sid;
	this.sname = sname;
	this.squal = squal;
	this.scontact = contact;
	this.saddr = saddr;
	this.semail = semail;
	this.spass = spass;
	this.iid=iid;

}

//public Student(int sid, String sname, String squal, long contact, String saddr,
//		String semail, String status) {
//	super();
//	this.sid = sid;
//	this.sname = sname;
//	this.squal = squal;
//	this.scontact = contact;
//	this.saddr = saddr;
//	this.semail = semail;
//	this.status = status;
//}

public Student(int sid, String sname, String squal, String contact, String saddr,
		String semail, String spass, String status, int iid) {
	super();
	this.sid = sid;
	this.sname = sname;
	this.squal = squal;
	this.scontact = contact;
	this.saddr = saddr;
	this.semail = semail;
	this.spass = spass;
	this.status = status;
	this.iid = iid;
}
public int getSid() {
	return sid;
}
public void setSid(int sid) {
	this.sid = sid;
}
public String getSname() {
	return sname;
}
public void setSname(String sname) {
	this.sname = sname;
}
public String getSqual() {
	return squal;
}
public void setSqual(String squal) {
	this.squal = squal;
}
public String getContact() {
	return scontact;
}
public void setContact(String contact) {
	this.scontact = contact;
}
public String getSaddr() {
	return saddr;
}
public void setSaddr(String saddr) {
	this.saddr = saddr;
}
public String getSemail() {
	return semail;
}
public void setSemail(String semail) {
	this.semail = semail;
}
public String getSpass() {
	return spass;
}
public void setSpass(String spass) {
	this.spass = spass;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
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
	return "Student[student_id="+sid+",student_name="+sname+",student_quali="+squal+",contact_no="+scontact+",student_addr="+saddr+",student_email="+semail+",status="+status+",insti_id="+iid+"]";
	
}

public Student(String sname, String squal, String scontact, String saddr,
		String semail, String spass, String status, int iid) {
	super();
	this.sname = sname;
	this.squal = squal;
	this.scontact = scontact;
	this.saddr = saddr;
	this.semail = semail;
	this.spass = spass;
	this.status = status;
	this.iid = iid;
}

}
