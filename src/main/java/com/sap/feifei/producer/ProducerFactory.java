package com.sap.feifei.producer;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.odata4j.producer.ODataProducer;
import org.odata4j.producer.ODataProducerFactory;
import org.odata4j.producer.jpa.JPAProducer;
import org.springframework.beans.factory.annotation.Configurable;

@Configurable
public class ProducerFactory implements ODataProducerFactory{

	@PersistenceUnit (unitName = "default")
    private EntityManagerFactory emf;
	
	@Override
	public ODataProducer create(Properties properties) {
		JPAProducer producer = new JPAProducer(emf, "", 500);
		return producer;
	}

}
