package com.lakkam.springrestproject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lakkam.springrestproject.entity.Employee;
import com.lakkam.springrestproject.exceptions.EmployeeNotFoundException;

@RestController
@RequestMapping("/api")
public class SpringMainController {

	@GetMapping("/hello")
	public String getHello() {
		return "Hello World";
	}

	@GetMapping("/employee")
	public Employee getEmployee() throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper om = new ObjectMapper();
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("employee-data.json").getFile());
		Employee employee = om.readValue(file, Employee.class);
		return employee;

	}

	List<Employee> employeeList = new ArrayList<Employee>();

	@GetMapping("/getEmployeeList/{empId}")
	public Employee getListofEmployees(@PathVariable int empId) throws EmployeeNotFoundException {

		employeeList.add(new Employee(1, "Lakkam", "Manager"));
		employeeList.add(new Employee(2, "Nani", "Employee"));
		employeeList.add(new Employee(3, "Prachu", "Admin"));

		if (isEmployeeIdValid(empId, employeeList)) {
			for (Employee e : employeeList) {
				if (e.getEmpId() == empId) {
					return e;
				}

			}
		} else
			throw new EmployeeNotFoundException("Employee Not Found");
		
		return new Employee(); 

	}

	private boolean isEmployeeIdValid(int empId, List<Employee> employeeList2) {
		// return employeeList2.contains(Integer.valueOf(empId)) ? true : false;

		for (Employee e : employeeList2) {
			if (e.getEmpId() == empId) {
				return true;
			}

		}
		return false;
	}

}
