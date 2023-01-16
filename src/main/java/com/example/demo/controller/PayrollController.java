package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Response;
import com.example.demo.dto.RegisterDTO;
import com.example.demo.model.PayrollModel;
import com.example.demo.repositery.PayrollRepositery;
import com.example.demo.service.IpayrollService;

@RestController
@RequestMapping("/Emplyoee_Payroll")

public class PayrollController {

	    @Autowired
	    PayrollRepositery payrollRepositery;

	    @Autowired
	    IpayrollService ipayrollService;

	    @PostMapping("/Register_Employee")
	    public ResponseEntity<Response> registerEmp(@RequestBody RegisterDTO registerDTO) {
	        ipayrollService.registerEmp(registerDTO);
	        Response response = new Response(registerDTO, "Employee Registered Successfull");
	        return new ResponseEntity<>(response, HttpStatus.OK);
	    }

	    @GetMapping("/Find_Employee_Data")
	    public ResponseEntity<Response> getEmpData(@RequestParam int id) {
	        PayrollModel emplyoeeData = ipayrollService.getEmpData(id);
	        Response response = new Response(emplyoeeData, "Emplyoee Data");
	        return new ResponseEntity<>(response, HttpStatus.OK);
	    }

	    @DeleteMapping("/Delete_Employee_Data")
	    public ResponseEntity<Response> deleteEmpData(@RequestParam int id) {
	        ipayrollService.deleteEmpData(id);
	        Response response = new Response("Deleted Employee Data for id: " + id, "Deleted Successfully");
	        return new ResponseEntity<>(response, HttpStatus.OK);
	    }

	    @PutMapping("/Update_Employee_Data")
	    public ResponseEntity<Response> updateEmpData(@RequestParam int id, @RequestBody RegisterDTO registerDTO) {
	        PayrollModel update = ipayrollService.updateEmpData(id, registerDTO);
	        Response response = new Response(update, "Employee Data Updated Successfully");
	        return new ResponseEntity<>(response, HttpStatus.OK);
	    }

	    @GetMapping("/Show_All_Emp_Data")
	    public ResponseEntity<Response> showAllEmpData(@RequestParam int id){
	        List<PayrollModel> payrollModelList = ipayrollService.getAllEmployeeData(id);
	        Response response = new Response(payrollModelList, "All Employee Data" );
	        return new ResponseEntity<>(response, HttpStatus.OK);
	    }
}
