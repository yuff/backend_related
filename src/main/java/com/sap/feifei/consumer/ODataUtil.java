package com.sap.feifei.consumer;

import java.util.List;

import org.core4j.Enumerable;
import org.odata4j.consumer.ODataConsumer;
import org.odata4j.consumer.ODataConsumers;
import org.odata4j.core.OEntity;
import org.odata4j.core.OLink;

public class ODataUtil {
	private static ODataUtil odataUtil;

	public synchronized static ODataUtil getInstance() {
		if (odataUtil == null) {
			odataUtil = new ODataUtil();
		}
		return odataUtil;
	}
	
	public ODataConsumer buildConsumer(String serviceUrl) {
		ODataConsumer.dump.responseHeaders(true);
		ODataConsumer.Builder builder = ODataConsumers.newBuilder(serviceUrl);
		builder.setClientBehaviors(new MyOClientBehavior("feifei.yu@sap.com", "Yff19861030"));	
		return builder.build();
	}
	
	public void readEntities(ODataConsumer consumer, String entityName, String expandName) {
		Enumerable<OEntity> entities = consumer.getEntities(entityName).expand(expandName).execute();
		
		OEntity entity = entities.first();
		System.out.println(entity);
		List<OLink> links = entity.getLinks();
		System.out.println(links.size());
	}
}
