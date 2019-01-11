package com.example.dempmysql1;

import comp.pack.model.Student;
import comp.pack.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@SpringBootApplication(scanBasePackages = "comp.pack")
@EnableJpaRepositories(basePackages = "comp.pack.repo")
@EntityScan({"comp.pack.model"})
public class DempMysql1Application {

	@Autowired
	StudentRepo studentRepo;

	public static void main(String[] args) {
		SpringApplication.run(DempMysql1Application.class, args);

	}


	@RequestMapping(value = "get",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Student> getAll(){

			return studentRepo.findAll();

	}

}

