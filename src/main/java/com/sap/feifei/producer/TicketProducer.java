package com.sap.feifei.producer;

import javax.persistence.EntityManagerFactory;

import org.odata4j.producer.jpa.JPAProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component
public class TicketProducer {
	private EntityManagerFactory entityManagerFactory;

	@Autowired
	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	public JPAProducer createProducer(String namespace) {
		JPAProducer producer = new JPAProducer(this.entityManagerFactory, namespace, 50);
		return producer;
	}
}
