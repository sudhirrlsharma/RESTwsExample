package com.sudhir.config;


import org.glassfish.jersey.server.ResourceConfig;

import com.sudhir.filter.AuthenticationFilter;
 
public class CustomApplication extends ResourceConfig 
{
    public CustomApplication() 
    {
    	super(CustomApplication.class);
        packages("com.sudhir.service");
 
        //Register Auth Filter here
        register(AuthenticationFilter.class);
    }

}