package com.sea;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sea.model.Employee;
import com.sea.repository.EmployeeRepository;

@SpringBootApplication
@RestController
public class ElasticSearchApplication {

	@Autowired
	private EmployeeRepository repository;

	@PostMapping("/saveEmployee")
	public Employee saveEmployee(@RequestBody Employee employees) {
		System.out.println(employees.toString());
		repository.save(employees);
		return employees;
	}

	@GetMapping("/findEverything")
	public Iterable<Employee> findAllEmployees() {
		return repository.findAll();
	}

	@GetMapping("/findByFName/{firstName}")
	public List<Employee> findByFirstName(@PathVariable String firstName) {
		return repository.findByFirstname(firstName);
	}

	public static void main(String[] args) {
		SpringApplication.run(ElasticSearchApplication.class, args);
	}

}
