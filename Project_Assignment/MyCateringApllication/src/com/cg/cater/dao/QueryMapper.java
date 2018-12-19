package com.cg.cater.dao;

public interface QueryMapper {
	public static final String RETRIVE_ALL_QUERY="SELECT * FROM customers_details";
	public static final String VIEW_customer_DETAILS_QUERY="select *from customers_details where cater_id=?";
	public static final String INSERT_QUERY="insert into customers_Details values(cateringid.nextVal,?,?,?,Sysdate)";
	public static final String Select_ALL="select * from customers_Details";
	public static final String INSERT_combo="insert into comboo values(orderingid.nextVal,?,?)";
	public static final String selecting="select * from comboo";
}
