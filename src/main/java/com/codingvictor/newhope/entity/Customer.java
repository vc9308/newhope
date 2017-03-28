package com.codingvictor.newhope.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;


public class Customer  {
	
	@NotBlank(message="{email.not.blank}")
	@Email(message="{email.not.valid}")
	private String email;
	
	@NotBlank(message="{password.not.blank}")
	@Length(min=8, message="{password.short}")
	@Pattern(regexp = "(?=.*[a-zA-Z])", message = "{password.not.contains.letter}")
	private String password;
	
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
	
	@NotBlank(message="{companyName.not.blank}")
	private String companyName;
	
	@NotNull(message="{companyType.not.null}")
	private byte companyType;
	
	@NotNull(message="{gender.not.null}")
	private byte gender;
	
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

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public byte getCompanyType() {
		return companyType;
	}

	public void setCompanyType(byte companyType) {
		this.companyType = companyType;
	}

	public byte getGender() {
		return gender;
	}

	public void setGender(byte gender) {
		this.gender = gender;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}
	
}

