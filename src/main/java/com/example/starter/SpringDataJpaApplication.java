package com.example.starter;

import com.example.configuration.GlobalProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@PropertySource(value = "classpath:application.properties")  // application properties dosyasının adını değiştirirsek burdan tanıtabiliriz
@EnableConfigurationProperties(value = GlobalProperties.class)  // bulsun diye, value olarakta classı verdik
@EnableJpaRepositories(basePackages = {"com.example"}) // repositoryde bean oluşma hataları gibi şeyleri önlemek için
@ComponentScan(basePackages = {"com.example"}) // RestController, Service, Repository işaretlenen sınıfları bulması için
@EntityScan(basePackages = {"com.example"}) // Entity işaretlediğimiz sınıfı bulamazsa diye bu paket altında bi tara dedik
@SpringBootApplication
public class SpringDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}

}
