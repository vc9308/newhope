package com.codingvictor.newhope.entity;

import java.sql.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class Staff {

	@NotBlank(message="{email.not.blank}")
	@Email(message="{email.not.valid}")
	private String email;
	
	@NotBlank(message="{password.not.blank}")
	@Length(min=8, message="{password.short}")
	private String password;
	
	private String encryptedPassword;
	
	@NotBlank(message="{givenName.not.blank}")
	private String givenName;
	
	@NotBlank(message="{familyName.not.blank}")
	private String familyName;
	
	@NotNull(message="{country.not.null}")
	private short country;
	
	@NotNull(message="{province.not.null}")
	private short province;
	
	@NotBlank(message="{phoneNumber.not.blank}")
	@Length(min=11, max=15, message="{phoneNumber.not.valid}")
	private String phoneNumber;
	
	@NotNull(message="{gender.not.null}")
	private byte gender;
	
	private Date birthdate;
	
	private Date hiredate;
	
	@NotNull(message="{job.not.null}")
	private byte job;
	
	@NotNull(message="{department.not.null}")
	private byte department;

	private String salt;
	
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

	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
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

	public short getCountry() {
		return country;
	}

	public void setCountry(short country) {
		this.country = country;
	}

	public short getProvince() {
		return province;
	}

	public void setProvince(short province) {
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

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	@Override
	public String toString() {
		return "Staff [email=" + email + ", encryptedPassword=" + encryptedPassword + ", givenName=" + givenName
				+ ", familyName=" + familyName + ", country=" + country + ", province=" + province + ", phoneNumber="
				+ phoneNumber + ", gender=" + gender + ", birthdate=" + birthdate + ", hiredate=" + hiredate + ", job="
				+ job + ", department=" + department + ", salt=" + salt + "]";
	}
	
}

