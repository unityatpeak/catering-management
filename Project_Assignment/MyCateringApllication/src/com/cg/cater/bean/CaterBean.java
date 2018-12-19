package com.cg.cater.bean;

import java.sql.Date;

public class CaterBean {
	private String caterid;  //specify all the variables and getter and setter with to string method
	private String customername;
	private String phonenumber;
	private String address;
	private double payAmount;
	private Date deleverydate;
	private String comboname;
	public String getCaterid() {
		return caterid;
	}
	public void setCaterid(String caterid) {
		this.caterid = caterid;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getPayAmount() {
		return payAmount;
	}
	public void setPayAmount(double payAmount) {
		this.payAmount = payAmount;
	}
	public Date getDeleverydate() {
		return deleverydate;
	}
	public void setDeleverydate(Date deleverydate) {
		this.deleverydate = deleverydate;
	}
	public String getComboname() {
		return comboname;
	}
	public void setComboname(String comboname) {
		this.comboname = comboname;
	}
	@Override
	public String toString() {
		return "CaterBean [caterid=" + caterid + ", customername=" + customername + ", phonenumber=" + phonenumber
				+ ", address=" + address + ", deleverydate=" + deleverydate
				+ "]";
	}
	
	
	
	
	

}
