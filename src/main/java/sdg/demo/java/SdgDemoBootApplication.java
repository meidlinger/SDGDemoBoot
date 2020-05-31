package sdg.demo.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.jaegertracing.Configuration;
@SpringBootApplication
public class SdgDemoBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SdgDemoBootApplication.class, args);
	}

	@Bean
	public io.opentracing.Tracer tracer() {
		return Configuration.fromEnv().getTracer();
	}
}
