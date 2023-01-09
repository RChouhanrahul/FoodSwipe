package com.Admin.Service;

import java.util.List;

import com.Admin.Dao.AdminDao;
import com.Admin.Dao.Hotelsdao;
import com.Admin.Entity.Admin_info;
import com.Admin.Entity.Regedhotels;
import com.Admin.Entity.Requests;
import com.Admin.Entity.User_info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService implements ServiceInterface
{
	@Autowired
	private  AdminDao dobj;
	
	@Autowired
	private  Hotelsdao hdao;
	
	@Override
	public Admin_info storeadmin(Admin_info ad)
	{
		return dobj.save(ad);
	}

	@Override
	public Admin_info memberadmin(String username,String password) {
		Admin_info adm = dobj.getadmin(username, password);
		if(adm!=null)
		{
			return adm;
		}
		else
		{
			return null;
		}
	}

	@Override
	public List<Requests> getrequests()
	{
		List<Requests> ll =dobj.getrequested();
		return ll;
	}

	@Override
	public int addrequests(List<Requests> list)
	{
		
		for(Requests h :list)
		{
			Regedhotels temp = new Regedhotels();
			temp.setCertificate(h.getCertificate());
			temp.setCity(h.getCity());
			temp.setEmail(h.getEmail());
			temp.setGstin(h.getGstin());
			temp.setHname(h.getHname());
			temp.setImagelink(h.getImagelink());
			temp.setLocality(h.getLocality());
			temp.setOwnername(h.getOwnername());
			temp.setPassword(h.getPassword());
			temp.setUsername(h.getUsername());
			hdao.save(temp);
		}
		
		return list.size();
	}

	@Override
	public User_info deleteuser(String user)
	{
		return dobj.removeuser(user);
	}

	@Override
	public User_info getbyuname(String username)
	{
		return dobj.getusername(username);
	}

	@Override
	public String deleteadmin(Admin_info admin)
	{
		dobj.deletead(admin.getUsername());
		return "deleted";
	}

	@Override
	public Admin_info updateadmin(Admin_info admin)
	{
		return dobj.saveAndFlush(admin);
	}

	@Override
	public String deletereq(Integer req)
	{
		dobj.delete(req);
		return "deleted";
	}

	@Override
	public List<Regedhotels> verifieds() {
		return dobj.getallverifieds();
	}
	
	
	
}
