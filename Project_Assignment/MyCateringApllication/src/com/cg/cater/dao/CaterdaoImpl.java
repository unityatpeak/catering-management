package com.cg.cater.dao;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.cater.bean.CaterBean;
import com.cg.cater.bean.OrderBean;
import com.cg.cater.exception.CaterException;
import com.cg.cater.util.dbConnection;

public class CaterdaoImpl implements ICaterDao{
	Logger logger=Logger.getRootLogger();
	public CaterdaoImpl()
	{
	PropertyConfigurator.configure("resources//log4j.properties");
	
	}
	//------------------------ 1. Cater Application --------------------------
	/*******************************************************************************************************
	 - Function Name	:	addCustomerDetails(CaterBean cater)
	 - Input Parameters	:	CaterBean cater
	 - Return Type		:	String
	 - Throws			:  	DonorException
	 - Author			:	CAPGEMINI
	 - Creation Date	:	18/11/2016
	 - Description		:	Adding cater
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 ********************************************************************************************************/

	/*@Override
	 public double viewchoice( double payamount) throws ClassNotFoundException, IOException, SQLException, CaterException {
		Connection connection=dbConnection.getconnection();
		ResultSet resultset=null;
		PreparedStatement preparedstatement=null;
		double payAmount = 0 ;
		int queryresult=0;
		CaterBean combo=new CaterBean();
		
		try
		{
			preparedstatement=connection.prepareStatement("insert into combos values(comboid.nextVal,?,?)");
			preparedstatement.setString(1, combo.getComboname());//that 1 represent the first question mark,
			preparedstatement.setDouble(2, combo.getPayAmount());
			preparedstatement.executeUpdate();
			Statement st=null;
			st=connection.createStatement();
			resultset=st.executeQuery("select * from combo");
			while(resultset.next())
				{ 
				payamount=resultset.getDouble(3);
				
				}
		
	
			if(queryresult==0)
			{
				logger.error("Insertion failed ");
				throw new CaterException("Inserting comb details failed ");

			}
			else
			{
				logger.info("customer details added successfully:");
				return payAmount;
			}
                   
			                                                       
			}
	  catch(Exception sql)
		    {
		  sql.printStackTrace();
			logger.error(sql.getMessage());
			throw new CaterException("Tehnical problem occured refer log");
		    }
		
		finally
		{
			try 
			{
				//resultSet.close();
				preparedstatement.close();
				connection.close();
			}
			catch (SQLException sqlException) 
			{
				sqlException.printStackTrace();
				logger.error(sqlException.getMessage());
				throw new CaterException("Error in closing db connection");

			}
	}
	}*/
	
  @Override
  
	public String add(CaterBean cater) throws   ClassNotFoundException, IOException, SQLException, CaterException{
		Connection connection=dbConnection.getconnection();
		ResultSet resultset=null;
		PreparedStatement preparedstatement=null;
		String cateringid=null;
		int queryresult=0;
		
		try
		{
			preparedstatement=connection.prepareStatement(QueryMapper.INSERT_QUERY);
			preparedstatement.setString(1, cater.getCustomername());//that 1 represent the first question mark,
			preparedstatement.setString(2,cater.getAddress() );
			preparedstatement.setString(3, cater.getPhonenumber());
			queryresult=preparedstatement.executeUpdate();
			Statement st=null;
			st=connection.createStatement();
			preparedstatement=connection.prepareStatement(QueryMapper.Select_ALL);
			resultset=preparedstatement.executeQuery();
			if(resultset.next())
			{
				cateringid=resultset.getString(1);
						
			}
	
			if(queryresult==0)
			{
				logger.error("Insertion failed ");
				throw new CaterException("Inserting cust details failed ");

			}
			else
			{
				logger.info("cust details added successfully:");
				return cateringid;
			}

		}
		catch(SQLException sqlException)
		{
			sqlException.printStackTrace();
			logger.error(sqlException.getMessage());
			throw new CaterException("Tehnical problem occured refer log");
		}

		finally
		{
			try 
			{
				//resultSet.close();
				preparedstatement.close();
				connection.close();
			}
			catch (SQLException sqlException) 
			{
				sqlException.printStackTrace();
				logger.error(sqlException.getMessage());
				throw new CaterException("Error in closing db connection");

			}
		}
		
		
	}
  
  
  
//------------------------ 1. Cater Application --------------------------
	/*******************************************************************************************************
	 - Function Name	:	viewCustomerDetails(String caterId)
	 - Input Parameters	:	caterId
	 - Return Type		:	CaterBean
	 - Throws			:  	CaterException
	 - Author			:	CAPGEMINI
	 - Creation Date	:	18/11/2016
	 - Description		:	ViewCustomerDetails
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 ********************************************************************************************************/
	
	@Override
	
	public CaterBean viewCustomerDetails(String caterid)throws  CaterException, ClassNotFoundException, IOException, SQLException{
		Connection connection=dbConnection.getconnection();
		ResultSet resultset=null;
		Statement st=null;
		PreparedStatement preparedstatement=null;
		CaterBean cater=new CaterBean();
		st=connection.createStatement();
		resultset=st.executeQuery(QueryMapper.VIEW_customer_DETAILS_QUERY);
		
		try
		{
			while(resultset.next())
		{
		cater.setCaterid(resultset.getString(1));
		cater.setCustomername(resultset.getString(2));
		cater.setAddress(resultset.getString(3));
		cater.setPhonenumber(resultset.getString(4));
		cater.setDeleverydate(resultset.getDate(5));
	
		}
			if( cater != null)
			{
				logger.info("Record Found Successfully");
				return cater;
			}
			else
			{
				logger.info("Record Not Found Successfully");
				return null;
			}
			
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
			throw new CaterException(e.getMessage());
		}
		finally
		{
			try 
			{
				resultset.close();
				preparedstatement.close();
				connection.close();
			} 
			catch (SQLException e) 
			{
				logger.error(e.getMessage());
				throw new CaterException("Error in closing db connection");

			}
		}
		
	}

	
	//------------------------ 1. Cater Application --------------------------
	/*******************************************************************************************************
	 - Function Name	:	retriveAll()
	 - Input Parameters	:	
	 - Return Type		:	List
	 - Throws		    :  	CaterException
	 - Author	     	:	CAPGEMINI
	 - Creation Date	:	18/11/2016
	 - Description		:	return list
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 ********************************************************************************************************/
	
	
	@Override
	public List retrieveAll() throws  CaterException, ClassNotFoundException, IOException, SQLException {

		Connection connection=dbConnection.getconnection();
		int caterCount = 0;
		
		PreparedStatement ps=null;
		ResultSet resultset = null;
		
		List<CaterBean> caterList=new ArrayList<CaterBean>();
		try
		{
			ps=connection.prepareStatement(QueryMapper.RETRIVE_ALL_QUERY);
			resultset=ps.executeQuery();
			
			while(resultset.next())
			{	
				CaterBean cater=new CaterBean();
				cater.setCaterid(resultset.getString(1));
				cater.setCustomername(resultset.getString(2));
				cater.setAddress(resultset.getString(3));
				cater.setPhonenumber(resultset.getString(4));
				cater.setDeleverydate(resultset.getDate(5));
				
				caterList.add(cater);
				
		        caterCount++;
			}			
		
			
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			throw new  CaterException("Some tehnical problem has occured. please .....Refer log");
		}
		
		finally
		{
			try 
			{
				resultset.close();
				ps.close();
				connection.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
				throw new  CaterException("Error in...so closing db connection");

			}
		}
		
		if( caterCount == 0)
			return null;
		else
			return caterList;
	
		

}

	//------------------------ 1. Cater Application --------------------------
		/*******************************************************************************************************
		 - Function Name	:	addOrderDetails(OrderBean order)
		 - Input Parameters	:	OrderBean order
		 - Return Type		:	String
		 - Throws			:  	CaterException
		 - Author			:	CAPGEMINI
		 - Creation Date	:	18/11/2016
		 - Description		:	Adding order
		 * @throws SQLException 
		 * @throws IOException 
		 * @throws ClassNotFoundException 
		 ********************************************************************************************************/

	
	
	@Override
	public String add(OrderBean order) throws ClassNotFoundException, IOException, SQLException, CaterException {
		Connection connection=dbConnection.getconnection();
		ResultSet resultset=null;
		PreparedStatement preparedstatement=null;
		String orderid=null;
		int queryresult=0;
		
		try
		{
			preparedstatement=connection.prepareStatement(QueryMapper.INSERT_combo);
			//that 1 represent the first question mark,
			preparedstatement.setString(1,order.getComboname() );
			preparedstatement.setDouble(2, order.getTotalprice());
			queryresult=preparedstatement.executeUpdate();
			Statement st=null;
			st=connection.createStatement();
			resultset=st.executeQuery(QueryMapper.selecting);
			if(resultset.next())
			{
				orderid=resultset.getString(1);
						
			}
	
			if(queryresult==0)
			{
				logger.error("Insertion failed ");
				throw new CaterException("Inserting comboo details failed ");

			}
			else
			{
				logger.info("comboo details added successfully:");
				return orderid;
			}

		}
		catch(SQLException sqlException)
		{
			sqlException.printStackTrace();
			logger.error(sqlException.getMessage());
			throw new CaterException("Tehnical problem occured refer log");
		}

		finally
		{
			try 
			{
				//resultSet.close();
				preparedstatement.close();
				connection.close();
			}
			catch (SQLException sqlException) 
			{
				sqlException.printStackTrace();
				logger.error(sqlException.getMessage());
				throw new CaterException("Error in closing db connection");

			}
		}
		
		
	}
	}




	
