package com.vincent.inc.Communication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RestController;

import com.viescloud.llc.viesspringutils.ViesApplication;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@EnableFeignClients
public class CommunicationApplication extends ViesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommunicationApplication.class, args);
	}

	@Override
	public String getApplicationName() {
		return "Communication";
	}

}
