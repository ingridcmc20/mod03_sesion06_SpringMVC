package com.tecsup.gestion.ws.soap;
/*
import javax.xml.transform.Source;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.xml.transform.StringSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.ws.test.server.MockWebServiceClient;
import static org.springframework.ws.test.server.RequestCreators.*;
import static org.springframework.ws.test.server.ResponseMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextHierarchy({ 
		@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml"),
		@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/spring-ws.xml")
})
@WebAppConfiguration
*/
public class EmployeeSoapWSTest {
/*
	@Autowired
	private ApplicationContext applicationContext;

	private MockWebServiceClient mockClient;

	@Before
	public void createClient() {
		mockClient = MockWebServiceClient.createClient(applicationContext);
	}

	@Test
	public void customerEndpoint() throws Exception {
		Source requestPayload = new StringSource("<customerCountRequest xmlns='http://springframework.org/spring-ws'>"
				+ "<customerName>John Doe</customerName>" + "</customerCountRequest>");
		Source responsePayload = new StringSource("<customerCountResponse xmlns='http://springframework.org/spring-ws'>"
				+ "<customerCount>10</customerCount>" + "</customerCountResponse>");

		mockClient.sendRequest(withPayload(requestPayload)).andExpect(payload(responsePayload));
	}
	*/
}