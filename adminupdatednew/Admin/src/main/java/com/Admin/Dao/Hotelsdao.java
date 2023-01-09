package com.Admin.Dao;

import java.lang.annotation.Native;

import com.Admin.Entity.Regedhotels;
import com.Admin.Entity.Requests;

import org.hibernate.annotations.SQLInsert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Hotelsdao extends JpaRepository<Regedhotels, Long>
{
	
}
