package com.kuwy.security.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kuwy.security.dto.ApiResponse;
import com.kuwy.security.dto.UserDTO;
import com.kuwy.security.service.AuthenticationFacadeService;
import com.kuwy.security.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
	
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
    public static final String SUCCESS = "success";
    public static final String ROLE_ADMIN = "ROLE_ADMIN";
    public static final String ROLE_USER = "ROLE_USER";
    
    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationFacadeService authenticationFacadeService;
    
    @Secured({ROLE_ADMIN})
    @RequestMapping
    public ApiResponse listUser(){
        log.info(String.format("received request to list user %s", authenticationFacadeService.getAuthentication().getPrincipal()));
        return new ApiResponse(HttpStatus.OK, SUCCESS, userService.findAll());
    }

    @Secured({ROLE_ADMIN})
    @RequestMapping
    public ApiResponse create(@RequestBody UserDTO user){
        log.info(String.format("received request to create user %s", authenticationFacadeService.getAuthentication().getPrincipal()));
        return new ApiResponse(HttpStatus.OK, SUCCESS, userService.save(user));
    }

    @Secured({ROLE_ADMIN, ROLE_USER})
    @RequestMapping(value = "/{id}")
    public ApiResponse update(@PathVariable long id){
        log.info(String.format("received request to update user %s", authenticationFacadeService.getAuthentication().getPrincipal()));
        return new ApiResponse(HttpStatus.OK, SUCCESS, userService.findOne(id));
    }

    @Secured({ROLE_ADMIN})
    @RequestMapping(value = "/{id}")
    public void delete(@PathVariable(value = "id") Long id){
        log.info(String.format("received request to delete user %s", authenticationFacadeService.getAuthentication().getPrincipal()));
        userService.delete(id);
    }


}
