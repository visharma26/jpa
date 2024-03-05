package com.jpalearning.jpa;

import com.github.javafaker.Faker;
import com.jpalearning.jpa.models.Author;
import com.jpalearning.jpa.models.Video;
import com.jpalearning.jpa.repositories.AuthorRepository;
import com.jpalearning.jpa.repositories.VideoRepository;
import com.jpalearning.jpa.specification.AuthorSpecification;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.domain.Specification;

@SpringBootApplication
public class JpaApplication {

	/*
	docker run -d -v /Users/vineetsharma/Documents/Learning/docker/data/pgdata:/var/lib/postgresql/data -e POSTGRES_USERNAME=postgres -e POSTGRES_PASSWORD=postgres -p 5432:5432 postgres
	psql -h localhost -p 5432 -U postgres -W
	*/

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AuthorRepository repository, VideoRepository videoRepository){
		return args -> {
//			repository.findAllByFirstNameContainingIgnoreCase("s").forEach(t -> System.out.println(t.getFirstName()));
			/*for (int i =0; i<50;i++) {
				Faker faker = new Faker();
				var author = Author.builder()
						.firstName(faker.name().firstName())
						.lastName(faker.name().lastName())
						.age(faker.number().numberBetween(19,50))
						.email(String.format("%s@gmail.com",faker.name().username()))
						.build();
				repository.save(author);
			}*/
			/*var video = Video.builder()
					.name("abc")
					.length(6)
					.build();
			videoRepository.save(video);*/

			/*var author = Author.builder()
					.id(1)
					.firstName("vineet")
					.lastName("Sharma")
					.age(31)
					.email(String.format("%s@gmail.com","vineet.sharma"))
					.build();
			repository.save(author);*/
//			repository.updateAuthor(30,1);

			/*repository.findByNamedQuery(30)
					.forEach(t -> System.out.println(t.getFirstName()));
			repository.updateByNamedQuery(31,1);*/

			Specification<Author> specification = Specification
					.where(AuthorSpecification.hasAge(31))
					.or(AuthorSpecification.firstnameContains("v"));
			repository.findAll(specification).forEach(t -> System.out.println(t.getFirstName()));

		};
	}

}
