package com.kuwy.security.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kuwy.security.dto.UserDTO;
import com.kuwy.security.model.User;

@Service
public interface UserService {
	
	 UserDTO save(UserDTO user);
	    List<UserDTO> findAll();
	    User findOne(long id);
	    void delete(long id);

}
