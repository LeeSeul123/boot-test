package com.example.demo.customer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Customer {
	
	@Id
	//기본키
	@GeneratedValue(strategy = GenerationType.AUTO)
	//기본키 생성 옵션
	private Long id;
	@Column(nullable = false, length = 20)
	private String name;
	private String phone;
}
