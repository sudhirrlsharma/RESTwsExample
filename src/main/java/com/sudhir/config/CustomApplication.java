package com.sudhir.config;


import org.glassfish.jersey.server.ResourceConfig;

import com.sudhir.filter.AuthenticationFilter;
import com.sudhir.filter.RequestFilter;
import com.sudhir.filter.ResponseFilter;
import com.sudhir.intercepter.TestReaderInterceptor;
import com.sudhir.intercepter.TestWriterInterceptor;
 
public class CustomApplication extends ResourceConfig 
{
    public CustomApplication() 
    {
    	super(CustomApplication.class);
        packages("com.sudhir.service");

        //Register Filter here
////        System.out.println("Regesteringfilter");
////        register(ResponseFilter.class);
//
////        System.out.println("Regestering REQUEST filter");
////        register(RequestFilter.class);
////        
//        System.out.println("Regestering Interceptor");
//        register(TestWriterInterceptor.class);
////
//        System.out.println("Regestering READER Interceptor");
        register(TestReaderInterceptor.class);
//
        System.out.println("Regestering Auth filter");
        register(AuthenticationFilter.class);
    }

}