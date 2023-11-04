package com.example.handler;

import java.util.List;

public class ValidationResponce {

	private String massege;
	private List<String> list;

	public ValidationResponce() {

	}

	public ValidationResponce(String massege, List<String> list) {
		this.massege = massege;
		this.list = list;
	}

	public String getMassege() {
		return massege;
	}

	public void setMassege(String massege) {
		this.massege = massege;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

}
