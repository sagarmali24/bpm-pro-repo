package com.cch.processrecipes.utility;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;

public class ContextLoadListener extends ContextLoaderListener{
@Override
public void contextInitialized(ServletContextEvent event) {
	// TODO Auto-generated method stub
	super.contextInitialized(event);
	System.out.println("LISTENER");
	event.getServletContext().setAttribute("sagar", new Date());
}
}
