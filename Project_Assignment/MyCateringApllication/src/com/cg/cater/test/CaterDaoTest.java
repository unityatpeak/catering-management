package com.cg.cater.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.cg.cater.bean.CaterBean;
import com.cg.cater.bean.OrderBean;
import com.cg.cater.dao.CaterdaoImpl;
import com.cg.cater.exception.CaterException;

public class CaterDaoTest {
	static CaterdaoImpl dao;
	static CaterBean cater;
     static OrderBean order;

 	

 	
	@BeforeClass
	public static void initialize() {
		System.out.println("in before class");
		dao = new  CaterdaoImpl();
		order = new OrderBean();
		cater=new CaterBean();
	}

	@Test
	public void testAddcustomerDetails() throws CaterException, ClassNotFoundException, IOException, SQLException {

		assertNotNull(dao.add(cater));

	}

	/************************************
	 * Test case for addCustomerDetails()
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * 
	 ************************************/

	@Ignore
	@Test
	public void testAddcombooDetails() throws CaterException, ClassNotFoundException, IOException, SQLException {

		assertNotNull(dao.add(order));

	}

	/************************************
	 * Test case for addCustomerDetails()
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * 
	 ************************************/

	@Ignore
	
	@Test
	public void testcustomerDetails1() throws CaterException, ClassNotFoundException, IOException, SQLException {
		// increment the number next time you test for positive test case
		assertEquals(100, dao.add(cater));
	}

	/************************************
	 * Test case for addcustomerDetails()
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	
	 * 
	 ************************************/
	
	
	/************************************
	 * Test case for addcombooDetails()
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * @throws NumberFormatException 
	 * 
	 ************************************/
	
	@Test
	public void testAddCustomerDetails2() throws CaterException, NumberFormatException, ClassNotFoundException, IOException, SQLException {

		cater.setCustomername("Chithra");
		cater.setPhonenumber("9876543210");
		cater.setAddress("Chennai");
		assertTrue("Data Inserted successfully",
				Integer.parseInt(dao.add(cater)) > 100);

	}

	/********************************************
	 * Test case for retriveAllDetails()
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 ************************************************/
	
	
	
	
	@Test
	public void testAddcombooDetails2() throws CaterException, NumberFormatException, ClassNotFoundException, IOException, SQLException {
		order.setOrderid("1");
		order.setComboname("combo14");
		order.setTotalprice(430);
		
		assertTrue("Data Inserted successfully",
				Integer.parseInt(dao.add(order)) > 10);

	}

	/********************************************
	 * Test case for retriveAllDetails()
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 ************************************************/
	@Test
	public void testViewAll() throws CaterException, ClassNotFoundException, IOException, SQLException {
		assertNotNull(dao.retrieveAll());
	}

	/****************************************************
	 * Test case for viewById()
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 ******************************************************/

	
	@Ignore
	@Test
	public void testById1() throws CaterException, ClassNotFoundException, IOException, SQLException {
		assertEquals("TestName", dao.viewCustomerDetails("101").getCustomername());
	}
	

}
