package com.Admin.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.ManyToAny;



@Entity

public class Orders
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JsonIgnore
	private  User_info client; //foreign key
	@ManyToOne
	@JsonIgnore
	private Regedhotels hotelorders;  //foreign key
	private Long itemid;   //foreign key
	private Integer quantity;
	private String ordertime;
	private String delieveryadd;
	
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public User_info getClient() {
		return client;
	}
	public void setClient(User_info client) {
		this.client = client;
	}
	
	public Regedhotels getHotelorders() {
		return hotelorders;
	}
	public void setHotelorders(Regedhotels hotelorders) {
		this.hotelorders = hotelorders;
	}
	public Long getItemid() {
		return itemid;
	}
	public void setItemid(Long itemid) {
		this.itemid = itemid;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(String ordertime) {
		this.ordertime = ordertime;
	}
	public String getDelieveryadd() {
		return delieveryadd;
	}
	public void setDelieveryadd(String delieveryadd) {
		this.delieveryadd = delieveryadd;
	}
	
	
}
