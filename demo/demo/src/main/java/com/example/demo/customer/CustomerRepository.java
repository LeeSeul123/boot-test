package com.example.demo.customer;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
//mapper인터페이스와 같음. @Repository를 넣어야 bean등록이 됨
public interface CustomerRepository extends CrudRepository<Customer, Long>{
	//이름으로 검색하는 메소드 만들기(기본 제공 되지 않아서 만듦)
	List<Customer> findByName(String name);
}
