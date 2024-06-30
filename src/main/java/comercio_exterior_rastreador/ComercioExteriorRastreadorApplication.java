package comercio_exterior_rastreador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class ComercioExteriorRastreadorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComercioExteriorRastreadorApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public WebClient.Builder client() {
		return WebClient.builder();
	}
}
