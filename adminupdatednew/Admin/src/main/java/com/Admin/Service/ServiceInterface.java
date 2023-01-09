package com.Admin.Service;

import java.util.List;

import com.Admin.Entity.Admin_info;
import com.Admin.Entity.Regedhotels;
import com.Admin.Entity.Requests;
import com.Admin.Entity.User_info;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;

public interface ServiceInterface
{

	public Admin_info storeadmin(Admin_info ad);

	public Admin_info memberadmin(String username, String password);

	public List<Requests> getrequests();

	public int addrequests(List<Requests> list);

	public User_info deleteuser(String username);

	public User_info getbyuname(String username);

	public String deleteadmin(Admin_info admin);

	public Admin_info updateadmin(Admin_info admin);

	public String deletereq(Integer req);

	public List<Regedhotels> verifieds();
	
}
