package com.sap.feifei;

import org.odata4j.consumer.ODataConsumer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import com.sap.feifei.consumer.ODataUtil;

//@SpringBootApplication
public class Application extends SpringBootServletInitializer{

//	private static final String SERVICE_URL = "https://pslibraryi336048trial.hanatrial.ondemand.com/pslibrary/odata";
	private static final String SERVICE_URL = "http://localhost:8080/odata";
	
	public static void main(String[] args){
		System.setProperty("odata4j.consumerimpl", "");
		ODataConsumer consumer = ODataUtil.getInstance().buildConsumer(SERVICE_URL);
		ODataUtil.getInstance().readEntities(consumer, "Books", "UserDetails");
	}
}
