
package com.jverstry.LoginLogout.Authentication;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class MyAuthenticationProvider implements AuthenticationProvider {
	
	private static final List<GrantedAuthority> AUTHORITIES
		= new ArrayList<GrantedAuthority>();
	//create new granted authorities list and in that add a amiin authority and when user admin logs in grant him admin role
	
	private static final List<GrantedAuthority> ADMINAUTH = new ArrayList<GrantedAuthority>();

	static {
		AUTHORITIES.add(new SimpleGrantedAuthority("ROLE_USER"));
		AUTHORITIES.add(new SimpleGrantedAuthority("ROLE_ANONYMOUS"));
		ADMINAUTH.add(new SimpleGrantedAuthority("ROLE_ANONYMOUS"));
		ADMINAUTH.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}
	 @Value("${user}") private String VerifyUsername;
	 @Value("${password}") private String VerifyPassword;
	 
	@Override
	public Authentication authenticate(Authentication auth)
			throws AuthenticationException {
		
		if (auth.getName().equals(VerifyUsername) && auth.getCredentials().equals(VerifyPassword)) {
			System.out.println("user is trying to login");
			return new UsernamePasswordAuthenticationToken(auth.getName(),
				auth.getCredentials(), AUTHORITIES);
		}else if(auth.getName().equals("admin") && auth.getCredentials().equals("admin")){
			
			System.out.println("admin is trying to log into the system");
			return new UsernamePasswordAuthenticationToken(auth.getName(),
					auth.getCredentials(), ADMINAUTH);
		}
		else
		{
		
		throw new BadCredentialsException("Bad Credentials");
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		
		if ( authentication == null ) return false;
		return Authentication.class.isAssignableFrom(authentication);
		
	}
  
}