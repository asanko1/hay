package com.tredence.hay.model;

import java.math.BigInteger;
import java.util.Date;

public class Organizer {
	BigInteger organizer_id;
	String first_name, last_name, location, timezone, email, dept, Phone, teams_link;
	Date last_updated;
	public Organizer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Organizer(BigInteger organizer_id, String first_name, String last_name, String location, String timezone,
			String email, String dept, String phone, String teams_link, Date last_updated) {
		super();
		this.organizer_id = organizer_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.location = location;
		this.timezone = timezone;
		this.email = email;
		this.dept = dept;
		Phone = phone;
		this.teams_link = teams_link;
		this.last_updated = last_updated;
	}
	public BigInteger getOrganizer_id() {
		return organizer_id;
	}
	public void setOrganizer_id(BigInteger organizer_id) {
		this.organizer_id = organizer_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getTimezone() {
		return timezone;
	}
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getTeams_link() {
		return teams_link;
	}
	public void setTeams_link(String teams_link) {
		this.teams_link = teams_link;
	}
	public Date getLast_updated() {
		return last_updated;
	}
	public void setLast_updated(Date last_updated) {
		this.last_updated = last_updated;
	}
	

}
