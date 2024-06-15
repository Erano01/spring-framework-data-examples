package me.erano.com;

import java.util.NoSuchElementException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
  
//  Eğer bir web sunucusu veya başka bir sürekli çalışan bileşen yoksa, 
//  CommandLineRunner içindeki kod tamamlandığında uygulama kapanır 
//  bu springboot uygulamalarının tipik davranışıdır. -> bu sebepten spring-boot-starter-web ekledik.
  @Bean
  CommandLineRunner runner(PersonRepository repository) {
    return args -> {

      Person person = new Person();
      person.setName("John");

      repository.save(person);
      Person saved = repository.findById(person.getId()).orElseThrow(NoSuchElementException::new);
    };
  }
}