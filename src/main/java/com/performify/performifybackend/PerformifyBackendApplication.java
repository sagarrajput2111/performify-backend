package com.performify.performifybackend;

import com.performify.performifybackend.services.RegistrationService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class PerformifyBackendApplication {
	public static void main(String[] args) {


	ApplicationContext context= SpringApplication.run(PerformifyBackendApplication.class, args);
//	RegistrationService service=context.getBean(RegistrationService.class);
//	service.approve("002");
	}

}
