package io.day4;

import java.io.Serializable;

public class Student implements Serializable{//implements Serializable : 분쇄를 할 수 있다.

	private static final long serialVersionUID = 1L;
	

	private String name;
	private int age;
	private String address;

	public Student() {}
	public Student(String name, int age, String address) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override public String toString() {
		
		return "학생명 "+name+", 나이 "+age+", 주소 "+address;
		
	}
	
	
}
