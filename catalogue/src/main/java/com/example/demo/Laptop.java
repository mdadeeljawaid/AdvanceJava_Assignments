package com.example.demo;

public class Laptop {

	int lid;
	String lbrand;
	float lprice;

	public Laptop(int lid, String lbrand, float lprice) {
		this.lid = lid;
		this.lbrand = lbrand;
		this.lprice = lprice;
	}

	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getLbrand() {
		return lbrand;
	}
	public void setLbrand(String lbrand) {
		this.lbrand = lbrand;
	}
	public float getLprice() {
		return lprice;
	}
	public void setLprice(float lprice) {
		this.lprice = lprice;
	}


}
