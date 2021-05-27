package ua.lviv.iot.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@SpringBootApplication
@ComponentScan({"ua.lviv.iot.rest.controllers", "ua.lviv.iot.rest.service", "ua.lviv.iot.rest.exceptions", "ua.lviv.iot.rest.dal" })
@EntityScan("ua.lviv.iot.rest.models")
@EnableJpaRepositories("ua.lviv.iot.rest.dal")
public class ItemsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItemsApplication.class, args);
	}

}
