package com.Admin.Dao;

import java.util.List;

import com.Admin.Entity.Admin_info;
import com.Admin.Entity.Regedhotels;
import com.Admin.Entity.Requests;
import com.Admin.Entity.User_info;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public interface AdminDao extends JpaRepository<Admin_info, Long>
{

	@Query("From com.Admin.Entity.Admin_info u where u.id=:id")
	Admin_info getrecord(@Param ("id") Long id);

	@Query("From com.Admin.Entity.Admin_info u where u.username=:username and u.password=:password")
	Admin_info getadmin(@Param("username") String username,@Param("password") String password);

	@Query("from com.Admin.Entity.Requests")
	List<Requests> getrequested();

	@Query("delete com.Admin.Entity.User_info u where u.username=:user")
	User_info removeuser(@Param("user") String user);

	@Query("from com.Admin.Entity.User_info u where u.username=:username")
	User_info getusername(@Param("username") String username);

	@Query("Delete com.Admin.Entity.Admin_info u where u.username=:username ")
	void deletead(@Param("username") String username);

	@Query("Delete com.Admin.Entity.Requests r where r.id=:id")
	void delete(@Param("id") Integer username);
	
	@Query("from com.Admin.Entity.Regedhotels")
	List<Regedhotels> getallverifieds();
	
	
	
	
}
