package com.tariq.springboot.schoolmanagement.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="address")
public class Address {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Size(max=15)
	@Column(name="house_no")
	private String houseNo;
	
	@Size(max=15)
	@Column(name="street_no")
	private String streetNo;
	
	@Size(max=40)
	@Column(name="nearest_place")
	private String nearestPlace;
	
	@Size(max=40)
	@Column(name="city")
	private String city;
	
	@Size(max=40)
	@Column(name="mohalla")
	private String mohalla;
	
	@Size(max=40)
	@Column(name="thana")
	private String thana;
	
	@Size(max=40)
	@Column(name="distt")
	private String distt;
	
	@Size(max=50)
	@Column(name="states")
	private String states;
	
	@Size(max=6)
	@Pattern(regexp="^[0-9]*{6}$", message="Enter a valid 6 digit pin code number")
	@Column(name="pin_code")
	private String pinCode;
	
	@Size(max=20)
	@Column(name="address_type")
	private String addressType;
	
	@ManyToOne(fetch=FetchType.EAGER, 
			cascade={CascadeType.DETACH,
					CascadeType.MERGE,
					CascadeType.PERSIST,
					CascadeType.REFRESH})
	@JoinColumn(name = "teacher_id")
	private Teacher teacher;
	
//	public Address(){}

//	public Address(@Size(max = 10) String houseNo, @Size(max = 10) String streetNo, @Size(max = 40) String nearestPlace,
//			@Size(max = 40) String city, @Size(max = 40) String thana, @Size(max = 40) String distt,
//			@Size(max = 50) String states, 
//			@Size(max = 6) @Pattern(regexp="^[0-9]*{6}$", message="Enter a valid 6 digit pin code number") String pinCode) {
//		this.houseNo = houseNo;
//		this.streetNo = streetNo;
//		this.nearestPlace = nearestPlace;
//		this.city = city;
//		this.thana = thana;
//		this.distt = distt;
//		this.states = states;
//		this.pinCode = pinCode;
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getStreetNo() {
		return streetNo;
	}

	public void setStreetNo(String streetNo) {
		this.streetNo = streetNo;
	}

	public String getNearestPlace() {
		return nearestPlace;
	}

	public void setNearestPlace(String nearestPlace) {
		this.nearestPlace = nearestPlace;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getThana() {
		return thana;
	}

	public void setThana(String thana) {
		this.thana = thana;
	}

	public String getDistt() {
		return distt;
	}

	public void setDistt(String distt) {
		this.distt = distt;
	}

	public String getStates() {
		return states;
	}

	public void setStates(String states) {
		this.states = states;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public Teacher getTeacher() {
		return teacher;
	}
	
	public Address teacherDetail(Teacher teacher) {
		this.teacher = teacher;
		return this;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public String getAddressType() {
		return addressType;
	}
	
	public Address addressType(String addressType) {
		this.addressType = addressType;
		return this;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public String getMohalla() {
		return mohalla;
	}
	
	public Address mohalla(String mohalla) {
		this.mohalla = mohalla;
		return this;
	}

	public void setMohalla(String mohalla) {
		this.mohalla = mohalla;
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
		Address other = (Address) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", houseNo=" + houseNo + ", streetNo=" + streetNo + ", nearestPlace="
				+ nearestPlace + ", city=" + city + ", thana=" + thana + ", distt=" + distt + ", states=" + states
				+ ", pinCode=" + pinCode + "]";
	}
	
}
