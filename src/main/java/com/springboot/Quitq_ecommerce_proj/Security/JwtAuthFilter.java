package com.springboot.Quitq_ecommerce_proj.Security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthFilter extends UsernamePasswordAuthenticationFilter{
	
	
	private final AuthenticationManager authManager;
	private final JWTutil jwtutil;
	
	public JwtAuthFilter(AuthenticationManager authManager, JWTutil jwtutil) {
		super();
		this.authManager = authManager;
		this.jwtutil = jwtutil;
		
		setFilterProcessesUrl("/auth/login");
	}
	
	//when we try to login
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException
	{
		try {
			Map<String, String> creds = new ObjectMapper().readValue(request.getInputStream(), Map.class);
			
			UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(creds.get("email"), creds
					.get("password"));
			
			return authManager.authenticate(authToken);
		}
		
		catch(IOException e)
		{
			throw new RuntimeException(e);
		}
	}
	
	//for successful login
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			FilterChain chain, Authentication authresult) throws IOException, ServletException
	{
		String email = authresult.getName();
		UserDetails userDetails = (UserDetails) authresult.getPrincipal();

	String token = jwtutil.generateToken(email, Map.of("role", userDetails.getAuthorities().toString()));
		
		response.setContentType("application/json");
		response.getWriter().write("{\"token\":\"" + token + "\"}");
		response.getWriter().flush();
	}
	
	
	//if login failed 
	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed)
			 throws IOException, ServletException
	{
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		response.getWriter().write("Invalid email or password");
	}
}
	

