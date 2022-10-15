package portfolio_backend.web_server;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication(scanBasePackages = {"portfolio_backend.web_server.entity_classes",
"portfolio_backend.web_server.controller_classes",
"portfolio_backend.web_server.service_classes",
"portfolio_backend.web_server.repo_classes"
})
public class WebServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebServerApplication.class, args);
	}

}
