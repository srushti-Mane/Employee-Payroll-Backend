package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.RegisterDTO;
import com.example.demo.model.PayrollModel;

public interface IpayrollService {

	  String registerEmp(RegisterDTO registerDTO);

	    PayrollModel getEmpData(int id);
	    String deleteEmpData(int id);

	    PayrollModel updateEmpData(int id, RegisterDTO registerDTO);

	    List<PayrollModel> getAllEmployeeData(int id);

}
