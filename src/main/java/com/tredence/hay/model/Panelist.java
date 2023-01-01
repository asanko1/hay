package com.tredence.hay.model;

import java.math.BigInteger;
import java.util.Date;

public class Panelist {
	BigInteger panelist_id;
	String panelist_synthetic_key, first_name, last_name, city, country, timezone, email, skillset, Phone,  linkedin_url,leadership_profile, dept;
	Date last_updated;
	public Panelist() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Panelist(BigInteger panelist_id, String panelist_synthetic_key,String first_name, String last_name, String location, String timezone,
			String email, String skillset, String phone, String linkedin_url, Date last_updated, String leadership_profile, String dept) {
		super();
		this.panelist_id = panelist_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.panelist_synthetic_key=panelist_synthetic_key;
		this.timezone = timezone;
		this.email = email;
		this.skillset = skillset;
		Phone = phone;
		this.linkedin_url = linkedin_url;
		this.last_updated = last_updated;
		this.leadership_profile=leadership_profile;
		this.dept=dept;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getPanelist_synthetic_key() {
		return panelist_synthetic_key;
	}

	public void setPanelist_synthetic_key(String panelist_synthetic_key) {
		this.panelist_synthetic_key = panelist_synthetic_key;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLeadership_profile() {
		return leadership_profile;
	}

	public void setLeadership_profile(String leadership_profile) {
		this.leadership_profile = leadership_profile;
	}

	public BigInteger getPanelist_id() {
		return panelist_id;
	}
	public void setPanelist_id(BigInteger panelist_id) {
		this.panelist_id = panelist_id;
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
	public String getSkillset() {
		return skillset;
	}
	public void setSkillset(String skillset) {
		this.skillset = skillset;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getLinkedin_url() {
		return linkedin_url;
	}
	public void setLinkedin_url(String linkedin_url) {
		this.linkedin_url = linkedin_url;
	}
	public Date getLast_updated() {
		return last_updated;
	}
	public void setLast_updated(Date last_updated) {
		this.last_updated = last_updated;
	}
	
	
}
