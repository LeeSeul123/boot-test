package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.customer.Customer;
import com.example.demo.customer.CustomerRepository;

@SpringBootTest
class DemoApplicationTests {
	
	@Autowired
	CustomerRepository customerRepo;
	
	@Test
	void findbyname() {
		List<Customer> list = customerRepo.findByName("이순신");
		System.out.println(list);
		assertEquals("이순신", list.get(0).getName());
	}
	
	//@Test
	void findall() {
		Iterable<Customer> list = customerRepo.findAll();	//메소드에 마우스 올리면 return값이 어떤 타입인지 나옴
		//1번 방법 foreach
		//list.forEach(cust -> System.out.println(cust.getName()));
		
		Iterator<Customer> iter = list.iterator();
		//2번 방법 iterator = 반복자
		while(list.iterator().hasNext()) {	//hasNext = 다음이 있으면
			Customer cust = iter.next();	//next = 다음요소를 꺼내옴
			System.out.println(cust.getName());
		}
		
	}
	
	//@Test
	//등록과 수정(기본키가 있으면 수정)
	void save() {
		Customer cust = new Customer();
		cust.setName("이순신");
		cust.setPhone("011-1111");
		Customer result = customerRepo.save(cust);	//등록된 객체를 return
		//result와 name이 같은지 비교
		assertEquals(cust.getName(), result.getName());	//test할 때 반드시 true, false가 넘어와야 build할 때 test에서 에러가 안남
	}

}
