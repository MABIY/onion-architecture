package com.lh.onionarchitecture.web.api;

import com.lh.onionarchiecture.object.model.ObjectModelConfig;
import com.lh.onionarchitecture.application.service.ApplicationServiceConfig;
import com.lh.onionarchitecture.infrastructure.InfrastructureConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({ObjectModelConfig.class, InfrastructureConfig.class, ApplicationServiceConfig.class})
public class OnionArchitectureApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnionArchitectureApplication.class, args);
	}

}