package com.jdbc.demo;

public class Student {

	int stud_id;
	String f_name;
	String l_name;
	
	public Student(int stud_id, String f_name, String l_name) {
		super();
		this.stud_id = stud_id;
		this.f_name = f_name;
		this.l_name = l_name;
	}


	@Override
	public String toString() {
		return "Student [stud_id=" + stud_id + ", f_name=" + f_name + ", l_name=" + l_name + "]";
	}

	public int getStud_id() {
		return stud_id;
	}

	public void setStud_id(int stud_id) {
		this.stud_id = stud_id;
	}

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public String getL_name() {
		return l_name;
	}

	public void setL_name(String l_name) {
		this.l_name = l_name;
	}
	
	

}
