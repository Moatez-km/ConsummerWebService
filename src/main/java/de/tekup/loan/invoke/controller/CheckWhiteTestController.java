package de.tekup.loan.invoke.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import de.tekup.DS.soap.api.consume.whiteTest.StudentRequest;
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

	

}
