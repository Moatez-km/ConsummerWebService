package de.tekup.loan.invoke.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import de.tekup.DS.soap.api.consume.whiteTest.StudentRequest;
import de.tekup.DS.soap.api.consume.whiteTest.WhiteTestResponse;
import de.tekup.loan.invoke.client.SoapClient;

@Controller
public class CheckWhiteTestController {
	@Autowired
	private SoapClient client;
	
	@GetMapping("/check/student")
	public String checkForm(Model model) {
		StudentRequest request = new StudentRequest();
		model.addAttribute("request", request);
		return "request";
	}

	@PostMapping("/check/student")
	public String WhiteTests(@ModelAttribute("request") StudentRequest request,
			Model model) {
		WhiteTestResponse response = client.getWhiteTestDetails(request);
		model.addAttribute("response",response);
		return "response";
	}
	

}
