package SpringDB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import SpringDB.model.UserCrud;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserCrud.class)
public class SpringDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDbApplication.class, args);
	}
}
