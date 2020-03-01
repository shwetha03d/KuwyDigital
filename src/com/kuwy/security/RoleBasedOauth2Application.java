package com.kuwy.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*@SpringBootApplication
@EntityScan("models")
@ComponentScan({"com.kuwy.security","controller", "model", "dao"})
@EnableJpaRepositories(basePackages={"dao"})
public class SpringTester {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringTester.class, args);
	}

}
*/

@SpringBootApplication
@EnableAutoConfiguration
public class RoleBasedOauth2Application {

	public static void main(String[] args) {
		SpringApplication.run(RoleBasedOauth2Application.class, args);
	}

}

