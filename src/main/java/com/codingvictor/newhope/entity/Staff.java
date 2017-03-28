package com.codingvictor.newhope.entity;

import java.sql.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class Staff {

	@NotBlank(message="{email.not.blank}")
	@Email(message="{email.not.valid}")
	private String email;
	
	@NotBlank(message="{password.not.blank}")
	@Pattern(regexp="[0-9a-zA-Z]{6,30}", message="{password.not.valid}")
	private String password;
	
	@NotBlank(message="{givenName.not.blank}")
	private String givenName;
	
	@NotBlank(message="{familyName.not.blank}")
	private String familyName;
	
	@NotBlank(message="{country.not.blank}")
	private String country;
	
	@NotBlank(message="{province.not.blank}")
	private String province;
	
	@NotBlank(message="{phoneNumber.not.blank}")
	@Length(min=11, max=12, message="{phoneNumber.not.valid}")
	private String phoneNumber;
	
	@NotNull(message="{gender.not.null}")
	private byte gender;
	
	@NotBlank(message="{birthdate.not.blank}")
	private Date birthdate;
	
	@NotBlank(message="{hiredate.not.blank}")
	private Date hiredate;
	
	@NotNull(message="{job.not.null}")
	private byte job;
	
	@NotNull(message="{deparment.not.null}")
	private byte department;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGivenName() {
		return givenName;
	}

	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public byte getGender() {
		return gender;
	}

	public void setGender(byte gender) {
		this.gender = gender;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public byte getJob() {
		return job;
	}

	public void setJob(byte job) {
		this.job = job;
	}

	public byte getDepartment() {
		return department;
	}

	public void setDepartment(byte department) {
		this.department = department;
	}
	
}

