package com.canuncuoglu.runners;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.wavefront.WavefrontProperties.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import com.canuncuoglu.runners.run.Location;
import com.canuncuoglu.runners.run.Run;
import com.canuncuoglu.runners.user.User;
import com.canuncuoglu.runners.user.UserHttpClient;
import com.canuncuoglu.runners.user.UserRestClient;
import com.canuncuoglu.runners.run.JdbcClientRunRepository;


@SpringBootApplication
public class RunnersApplication {

	//private static final Logger log = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) {
		SpringApplication.run(RunnersApplication.class, args);
	}

	// @Bean
	// CommandLineRunner runner(RunRepository runRepository) {
	// 	return args -> {
	// 		Run run = new Run(1, "First run", LocalDateTime.now(), LocalDateTime.now().plusHours(1), 10, Location.OUTDOOR);
	// 		runRepository.create(run);
	// 		// log.info("Run: " + run);
	// 	};
	// }

	@Bean
	UserHttpClient UserHttpClient(){
		RestClient restClient = RestClient.create("https://jsonplaceholder.typicode.com/");
		HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(RestClientAdapter.create(restClient)).build();
		return factory.createClient(UserHttpClient.class);
	}

	@Bean
	CommandLineRunner runner(UserRestClient client){
		return args -> {
			List<User> users = client.findAll();
			//System.out.println(users);

			User user = client.findById(1);
			System.out.println(user);
		};
	}

}
