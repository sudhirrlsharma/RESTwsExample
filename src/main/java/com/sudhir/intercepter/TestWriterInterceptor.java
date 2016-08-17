package com.sudhir.intercepter;

import java.io.IOException;
import java.io.OutputStream;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.WriterInterceptor;
import javax.ws.rs.ext.WriterInterceptorContext;

public class TestWriterInterceptor  implements WriterInterceptor{
	 @Override
	    public void aroundWriteTo(WriterInterceptorContext interceptorContext)
	            throws IOException, WebApplicationException {
	        System.out.println("ServerWriterInterceptor2 invoked.");
	        OutputStream outputStream = interceptorContext.getOutputStream();
	        String responseContent = "\nResponse changed in ServerWriterInterceptor2.";
	        outputStream.write(responseContent.getBytes());
	        interceptorContext.setOutputStream(outputStream);
	 
	        interceptorContext.proceed();
	    }
}
