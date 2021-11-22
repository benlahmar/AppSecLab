package com.example.demo.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.User;

public interface Userrepo extends JpaRepository<User, Long>{

	User findByLogAndPass(String log,String pass);
	@Query(value = "select * from user where log=?1 and pass=?2", nativeQuery=true)
	User findByLogAndPass2(String log,String pass);
}
