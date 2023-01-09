package com.Admin.Controller;

import com.Admin.Entity.Admin_info;
import com.Admin.Service.ServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins ="http://localhost:4200")
@RequestMapping("/Admin")
public class AdminloginController
{
	@Autowired
	private ServiceInterface serf;
	
	@GetMapping("/login/{username}/{password}")
	public Admin_info getadmin(@PathVariable("username") String username, @PathVariable("password") String password)
	{
		return serf.memberadmin(username,password);
	}
}
