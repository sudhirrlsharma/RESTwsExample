package com.sudhir.intercepter;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.ReaderInterceptor;
import javax.ws.rs.ext.ReaderInterceptorContext;

@Provider
public class TestReaderInterceptor implements ReaderInterceptor  {
	@Override
    public Object aroundReadFrom(ReaderInterceptorContext interceptorContext)
            throws IOException, WebApplicationException {
        System.out.println("ServerReaderInterceptor2 invoked.");
        InputStream inputStream = interceptorContext.getInputStream();
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes);
        String requestContent = new String(bytes);
        requestContent = requestContent
                + "\nRequest changed in ServerReaderInterceptor2.";
        System.out.println(" NEW REST REQUEST");
        interceptorContext.setInputStream(new ByteArrayInputStream(
                requestContent.getBytes()));
        return interceptorContext.proceed();
    }
}
