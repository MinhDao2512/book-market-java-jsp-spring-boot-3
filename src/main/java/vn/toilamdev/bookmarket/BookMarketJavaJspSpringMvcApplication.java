package vn.toilamdev.bookmarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class)
// @SpringBootApplication
public class BookMarketJavaJspSpringMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookMarketJavaJspSpringMvcApplication.class, args);
	}

}
