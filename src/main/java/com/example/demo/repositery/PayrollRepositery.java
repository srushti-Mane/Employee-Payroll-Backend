package com.example.demo.repositery;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.PayrollModel;

@Repository
public interface PayrollRepositery extends JpaRepository<PayrollModel, Integer> {

	    PayrollModel findByEmail(String email);
	}


