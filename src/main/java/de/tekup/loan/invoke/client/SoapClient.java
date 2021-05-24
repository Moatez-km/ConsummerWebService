package de.tekup.loan.invoke.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import de.tekup.DS.soap.api.consume.whiteTest.StudentRequest;
import de.tekup.DS.soap.api.consume.whiteTest.WhiteTestResponse;



@Service
public class SoapClient {
	
	private WebServiceTemplate serviceTemplate;
	
	@Autowired
	private Jaxb2Marshaller marshaller;
	
	public WhiteTestResponse getWhiteTestDetails(StudentRequest studentRequest)
	{
		serviceTemplate = new WebServiceTemplate(marshaller);
		WhiteTestResponse response = (WhiteTestResponse) serviceTemplate.
				marshalSendAndReceive("http://localhost:8090/ws",studentRequest);
		return response;
	}

}
