package com.tredence.hay.model;

import java.math.BigInteger;
import java.util.Date;

public class Profile {
	BigInteger profile_id;
	String  first_name, last_name, profile_sythetic_key,primary_phn, primary_email, sec_phn, sec_email, city, country, source, ref_emp_id, resume, blacklisted, visa_status,linkedin_url,github_url,status,last_updated_by;
	Date last_updated;
	
	
	
	public Profile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Profile(BigInteger profile_id, String first_name, String last_name, String profile_sythetic_key, String primary_phn, String primary_email, String sec_phn, String sec_email, String city, String country, String source, String ref_emp_id, String resume, String blacklisted, String visa_status, String linkedin_url, String github_url, String status, Date last_updated, String last_updated_by) {
		this.profile_id = profile_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.profile_sythetic_key = profile_sythetic_key;
		this.primary_phn = primary_phn;
		this.primary_email = primary_email;
		this.sec_phn = sec_phn;
		this.sec_email = sec_email;
		this.city = city;
		this.country = country;
		this.source = source;
		this.ref_emp_id = ref_emp_id;
		this.resume = resume;
		this.blacklisted = blacklisted;
		this.visa_status = visa_status;
		this.linkedin_url = linkedin_url;
		this.github_url = github_url;
		this.status = status;
		this.last_updated = last_updated;
		this.last_updated_by=last_updated_by;
	}

	public String getLast_updated_by() {
		return last_updated_by;
	}

	public void setLast_updated_by(String last_updated_by) {
		this.last_updated_by = last_updated_by;
	}

	public String getProfile_sythetic_key() {
		return profile_sythetic_key;
	}

	public void setProfile_sythetic_key(String profile_sythetic_key) {
		this.profile_sythetic_key = profile_sythetic_key;
	}

	public BigInteger getProfile_id() {
		return profile_id;
	}
	public void setProfile_id(BigInteger profile_id) {
		this.profile_id = profile_id;
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
	public String getPrimary_phn() {
		return primary_phn;
	}
	public void setPrimary_phn(String primary_phn) {
		this.primary_phn = primary_phn;
	}
	public String getPrimary_email() {
		return primary_email;
	}
	public void setPrimary_email(String primary_email) {
		this.primary_email = primary_email;
	}
	public String getSec_phn() {
		return sec_phn;
	}
	public void setSec_phn(String sec_phn) {
		this.sec_phn = sec_phn;
	}
	public String getSec_email() {
		return sec_email;
	}
	public void setSec_email(String sec_email) {
		this.sec_email = sec_email;
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
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getRef_emp_id() {
		return ref_emp_id;
	}
	public void setRef_emp_id(String ref_emp_id) {
		this.ref_emp_id = ref_emp_id;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	public String getBlacklisted() {
		return blacklisted;
	}
	public void setBlacklisted(String blacklisted) {
		this.blacklisted = blacklisted;
	}
	public String getVisa_status() {
		return visa_status;
	}
	public void setVisa_status(String visa_status) {
		this.visa_status = visa_status;
	}
	public Date getLast_updated() {
		return last_updated;
	}
	public void setLast_updated(Date last_updated) {
		this.last_updated = last_updated;
	}
	public String getLinkedin_url() {
		return linkedin_url;
	}
	public void setLinkedin_url(String linkedin_url) {
		this.linkedin_url = linkedin_url;
	}
	public String getGithub_url() {
		return github_url;
	}
	public void setGithub_url(String github_url) {
		this.github_url = github_url;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
