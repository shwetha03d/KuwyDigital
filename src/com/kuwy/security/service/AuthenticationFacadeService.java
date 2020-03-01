package com.kuwy.security.service;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public interface AuthenticationFacadeService {
	
	 Authentication getAuthentication();

}
