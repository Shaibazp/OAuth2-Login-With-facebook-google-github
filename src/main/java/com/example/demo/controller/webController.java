package com.example.demo.controller;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class webController 
{
	@GetMapping("/all")
	public String showAll()
	{
		return "Welcome to all";
	}
	
	@GetMapping("/data")
	public String showData()
	{
		return "Welcome to all";
	}
	
	@GetMapping("/info")
	public Authentication showInfo(Principal p)
	{
		System.out.println(p.getClass().getName());
		return SecurityContextHolder.getContext().getAuthentication();
	}
}
