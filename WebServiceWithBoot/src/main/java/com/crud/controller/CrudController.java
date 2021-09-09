package com.crud.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.entity.Employee;
import com.crud.entity.SmsEntity;
import com.crud.service.EmployeeService;
import com.crud.service.SmsService;
import org.springframework.http.MediaType;

@CrossOrigin(origins = "http://localhost:8080/")
@RestController
@ResponseBody
public class CrudController {
	@Autowired
	EmployeeService empservice;
	@Autowired
	SmsService service;
	@Autowired
	private SimpMessagingTemplate webSocket;

	// sending sms

	private final String TOPIC_DESTINATION = "/lesson/sms";

	@PostMapping(value = "/sms")
	public void smsSubmit(@RequestBody SmsEntity sms) {
		try {
			service.send(sms);
		} catch (Exception e) {

			webSocket.convertAndSend(TOPIC_DESTINATION, getTimeStamp() + ": Error sending the SMS: " + e.getMessage());
			throw e;
		}
		webSocket.convertAndSend(TOPIC_DESTINATION, getTimeStamp() + ": SMS has been sent!: " + sms.getTo());

	}

	@PostMapping(value = "/smscallback")
	public void smsCallback(@RequestBody MultiValueMap<String, String> map) {
		service.receive(map);
		webSocket.convertAndSend(TOPIC_DESTINATION,
				getTimeStamp() + ": Twilio has made a callback request! Here are the contents: " + map.toString());
	}

	private String getTimeStamp() {
		return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
	}

	// crud operation

	//@PostMapping(value="/save",produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	@PostMapping(value="employee",produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	
	public int newEmployee(@RequestBody Employee employee) {
		System.out.println("called by client");
		// response.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");
		System.out.println("employee id::" + employee.getEmployee_id());
		System.out.println("employee name::" + employee.getEmployee_name());
		Employee returnID = empservice.saveEmployee(employee);
		int employeeId = returnID.getEmployee_id();
		System.out.println("employeeId::::" + employeeId);
		return employeeId;

	}

	//@GetMapping("/allemployee")
	@GetMapping(value="employee",produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> getAllemp(HttpServletResponse response, HttpServletRequest request) {
		List<Employee> allEmployee = empservice.getAllEmployee();

		// response.setHeader("Access-Control-Allow-Origin","http://localhost:8080");

//		try {
//			if(!allEmployee.isEmpty()) {
//			response.setHeader("Access-Control-Allow-Origin", "*");	
//			 response.setContentType("text/javascript");
//             response.getWriter().write("{success:true,successvalue:" + allEmployee + "}");
//             response.getWriter().flush();
//			} else {
//			response.setHeader("Access-Control-Allow-Origin", "*");
//			response.setContentType("text/javascript");
//             response.getWriter().write("{failure:true,failurevalue:failed}");
//             response.getWriter().flush();
//			}
//		} catch (IOException e) {
//			 TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		// return null;
		return allEmployee;

	}

	@GetMapping("/employeesingle/{emp_id}")
	public Employee getEmployeebyID(@PathVariable("emp_id") String emp_id) {
		Employee employee = empservice.getEmployeeByID(emp_id);
		return employee;

	}

	@PutMapping("/edit/{emp_id}")
	public int upadteById(@PathVariable("emp_id") String emp_id, @RequestBody Employee employee) {
		Employee update = empservice.updateEmployeeById(emp_id, employee);

		return update.getEmployee_id();

	}

	@DeleteMapping("/deleteEmployee/{emp_id}")
	public String deleteIdByid(HttpServletResponse response, HttpServletRequest request,
			@PathVariable("emp_id") String emp_id) {
		// Employee returnId=

		String deleteSuccess = empservice.deleteEmployee(emp_id);
//		response.setHeader("Access-Control-Allow-Origin","http://localhost:8080");	
//		response.setHeader("Access-Control-Allow-Methods","DELETE");
		// String deletedId=returnId.getEmployee_id();
		// return new ResponseEntity<>("Person is deleted successsfully",
		// HttpStatus.OK);
		return deleteSuccess;
	}

}
