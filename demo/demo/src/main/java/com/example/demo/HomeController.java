package com.example.demo;

import java.util.Date;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.chat.Greeting;
import com.example.demo.customer.Customer;
import com.example.demo.customer.CustomerRepository;

@RestController
public class HomeController {
	
	@Autowired CustomerRepository repo;
	
	@Autowired
	private SimpMessagingTemplate template;
	
	@GetMapping("/cust")
	//cust요청할 때마다 cust 조회했다고 메세지를 보내는 메소드
	public Iterator<Customer> cust(){
		String text = "[" + new Date() + "]:" + "cust select";
        this.template.convertAndSend("/topic/cust", new Greeting(text));	//무조건 json으로 보내야 함
		return repo.findAll().iterator();
	}
}
