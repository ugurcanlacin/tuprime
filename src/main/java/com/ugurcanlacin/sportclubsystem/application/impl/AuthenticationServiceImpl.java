package com.ugurcanlacin.sportclubsystem.application.impl;



import javax.annotation.Resource;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.ugurcanlacin.sportclubsystem.application.AuthenticationService;

@Service("authenticationService")
public class AuthenticationServiceImpl implements AuthenticationService{

	
	@Resource(name = "authenticationManager")
	private AuthenticationManager authenticationManager; // specific for Spring Security
	
	public boolean login(String username, String password) {
		
		try {
			Authentication authenticate = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(
							username, password));
			if (authenticate.isAuthenticated()) {
				SecurityContextHolder.getContext().setAuthentication(
						authenticate);	
				System.out.println("Giris saglandi!");
				return true;
			}
		} catch (AuthenticationException e) {			
		}
		return false;
	}

}
