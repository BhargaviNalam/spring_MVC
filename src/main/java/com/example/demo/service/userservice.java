package com.example.demo.service;

import java.util.List;

import com.example.demo.models.user;

public interface userservice {
	
	List<user> getallusers();
	void saveuser(user u);
	void deleteuser(long id);
	user getbyid(long id);
	
}
