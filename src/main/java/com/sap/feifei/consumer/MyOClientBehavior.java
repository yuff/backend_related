package com.sap.feifei.consumer;

import java.util.List;

import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.NewCookie;

import org.apache.tomcat.util.codec.binary.Base64;
import org.odata4j.consumer.ODataClientRequest;
import org.odata4j.jersey.consumer.behaviors.JerseyClientBehavior;

import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientRequest;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.filter.ClientFilter;
import com.sun.jersey.api.client.filter.Filterable;

public class MyOClientBehavior implements JerseyClientBehavior {

	private String xsrfCookieName;
	private String xsrfCookieValue;
	private String xsrfTokenValue;
	private String userName;
	private String password;

	public MyOClientBehavior(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	@Override
	public ODataClientRequest transform(ODataClientRequest request) {
		String userPassword = userName + ":" + password;
		String encoded = Base64.encodeBase64String(userPassword.getBytes());
		encoded = encoded.replaceAll("\r\n?", "");
		if (request.getMethod().equals("GET")) {
			request = request.header("X-CSRF-Token", "Fetch").header("Authorization", "Basic " + encoded);
			return request;
		}
		else {
			request = request.header("X-CSRF-Token", xsrfTokenValue)
			                 .header("Cookie", xsrfCookieName + "=" + xsrfCookieValue)
			                 .header("Authorization", "Basic " + encoded);
			return request;
		}
	}

	@Override
	public void modify(ClientConfig clientConfig) {
		// TODO Auto-generated method stub
	}

	@Override
	public void modifyClientFilters(Filterable client) {
		client.addFilter(new ClientFilter() {

			@Override
			public ClientResponse handle(ClientRequest clientRequest) throws ClientHandlerException {
				ClientResponse response = getNext().handle(clientRequest);

				List<NewCookie> cookies = response.getCookies();

				for (NewCookie cookie : cookies) {
					if (cookie.getName().startsWith("sap-XSRF")) {
						xsrfCookieName = cookie.getName();
						xsrfCookieValue = cookie.getValue();
						break;
					}
				}

				MultivaluedMap<String, String> responseHeaders = response.getHeaders();
				xsrfTokenValue = responseHeaders.getFirst("X-CSRF-Token");
				return response;
			}
		});

	}

	@Override
	public void modifyWebResourceFilters(Filterable webResource) {
		// TODO Auto-generated method stub
	}

}
