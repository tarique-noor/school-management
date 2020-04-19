package com.tariq.springboot.schoolmanagement.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="teacher")
public class Teacher {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Size(max=50)
	@Column(name="first_name")
	private String firstName;
	
	@Size(max=50)
	@Column(name="last_name")
	private String lastName;
	
	@Size(max=50)
	@Column(name="email")
	private String email;
	
	@Size(max=10)
	@Pattern(regexp="^[0-9]*{10}$", message="Enter a valid 10 digit mobile number")
	@Column(name="mobile")
	private String mobile;
	
	@Size(max=20)
	@Column(name="service_type")
	private String serviceType;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name="joining_date")
	private Date joinDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name="leaving_date")
	private Date leavingDate;
	
	@Column(name="is_present")
	private boolean isPresent;
	
	@Size(max=6)
	@Column(name="gender")
	private String gender;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="teacher", 
			cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private List<Address> addresses = new ArrayList<>(0);
	
//	public Teacher(){}

//	public Teacher(@Size(max = 50) String firstName, @Size(max = 50) String lastName,
//			@Size(max = 50) String email,
//			@Size(max = 10) @Pattern(regexp = "^[0-9]*{10}$", message = "Enter a valid 10 digit mobile number") String mobile,
//			@Size(max = 20) String serviceType, Date joinDate, Date leavingDate, boolean isPresent,
//			@Size(max = 6) String gender) {
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.email = email;
//		this.mobile = mobile;
//		this.serviceType = serviceType;
//		this.joinDate = joinDate;
//		this.leavingDate = leavingDate;
//		this.isPresent = isPresent;
//		this.gender = gender;
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}
	
	public Teacher firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	public Teacher lastName(String lastName){
		this.lastName = lastName;
		return this;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}
	
	public Teacher email(String email){
		this.email = email;
		return this;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}
	
	public Teacher mobile(String mobile) {
		this.mobile = mobile;
		return this;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getServiceType() {
		return serviceType;
	}
	
	public Teacher serviceType(String serviceType) {
		this.serviceType = serviceType;
		return this;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public Date getJoinDate() {
		return joinDate;
	}
	
	public Teacher joinDate(Date joinDate) {
		this.joinDate = joinDate;
		return this;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public Date getLeavingDate() {
		return leavingDate;
	}
	
	public Teacher leavingDate(Date leavingDate) {
		this.leavingDate = leavingDate;
		return this;
	}

	public void setLeavingDate(Date leavingDate) {
		this.leavingDate = leavingDate;
	}

	public boolean isPresent() {
		return isPresent;
	}
	
	public Teacher isPresent(boolean isPresent) {
		this.isPresent = isPresent;
		return this;
	}

	public void setPresent(boolean isPresent) {
		this.isPresent = isPresent;
	}

	public String getGender() {
		return gender;
	}
	
	public Teacher gender(String gender) {
		this.gender = gender;
		return this;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<Address> getAddresses() {
		return addresses;
	}
	
	public Teacher addresses(List<Address> addresses) {
		this.addresses = addresses;
		return this;
	}
	
	public Teacher addAddress(Address address){
		this.addresses.add(address);
		address.setTeacher(this);
		return this;
	}
	
	public Teacher removeAddress(Address address){
		this.addresses.remove(address);
		address.setTeacher(null);
		return this;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Teacher other = (Teacher) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TeacherDetail [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", mobile=" + mobile + ", serviceType=" + serviceType + ", joinDate=" + joinDate + ", leavingDate="
				+ leavingDate + ", isPresent=" + isPresent + ", gender=" + gender + "]";
	}

}
