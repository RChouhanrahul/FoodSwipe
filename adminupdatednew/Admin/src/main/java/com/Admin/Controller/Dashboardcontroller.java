package com.Admin.Controller;

import java.util.List;

import com.Admin.Entity.Admin_info;
import com.Admin.Entity.Regedhotels;
import com.Admin.Entity.Requests;
import com.Admin.Entity.User_info;
import com.Admin.Service.ServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins ="http://localhost:4200")
@RequestMapping("Admin/Dashboard")
public class Dashboardcontroller
{
	@Autowired
	private ServiceInterface serf;
	
	@GetMapping("/getrequests")
	public List<Requests> getallrequests()
	{
		return serf.getrequests();
	}
	
	@PostMapping("/Registerhotels")
	public int addaccepted(@RequestBody List<Requests> list)
	{
		int i= serf.addrequests(list);
		 if(list.size()>0)
		 {
			 return i;
		 }
		 else
		 {
			 return 0;
		 }
	}
	
	@GetMapping("/getclienbyname/{username}")
	public User_info getclinetbyname(@PathVariable("username") String username)
	{
		return serf.getbyuname(username);
	}
	
	@DeleteMapping("/deleteclient")
	public User_info deleteclient(@RequestBody User_info user)
	{
		User_info u = serf.deleteuser(user.getUsername());
		return u;
	}
	
	@DeleteMapping("/deleteadmin")
	public String deleteadmin(@RequestBody Admin_info admin)
	{
		return serf.deleteadmin(admin);
	}
	
	@PutMapping("/updateadmin")
	public Admin_info updateadmin(@RequestBody Admin_info admin)
	{
		return serf.updateadmin(admin);
	}
	
	@GetMapping("/deleterequest/{id}")
	public String deleterequest(@PathVariable("id") Integer req)
	{
		return serf.deletereq(req);
	}
	
	@GetMapping("/getverifieds")
	public List<Regedhotels> getallmem()
	{
		return serf.verifieds();
	}
}
