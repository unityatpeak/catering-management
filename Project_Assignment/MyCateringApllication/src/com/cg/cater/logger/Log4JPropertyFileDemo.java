package com.cg.cater.logger;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4JPropertyFileDemo {	
	static Logger myLogger=Logger.getLogger(Log4JPropertyFileDemo.class.getName());

Object x;
public void do_something(int a,float f)
{
	myLogger.debug("operation performed successfully");
	myLogger.info("do something are:" +a+""+f);
	if(x==null)
	{
		myLogger.error("value of x is null");
		
	}
}
public static void main(String[] args) {
PropertyConfigurator.configure("rsource/Log4j.properties");
Log4JPropertyFileDemo m=new Log4JPropertyFileDemo();
m.do_something(1,(float)1.2);

}
}
