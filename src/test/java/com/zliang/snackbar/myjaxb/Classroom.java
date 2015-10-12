package com.zliang.snackbar.myjaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
// @XmlAccessorOrder(XmlAccessOrder.UNDEFINED)
//@XmlType(name = "classroom", propOrder = { "id", "rName", "address" })
@XmlAccessorType(XmlAccessType.FIELD)
public class Classroom {

//	@XmlElement
	@XmlAttribute(name="rId")
	private int id;
	
	@XmlTransient
	private String memo;

//	@XmlElement
	private String rName;
	
//	@XmlElement
//	@XmlTransient
	private Address address;

	public Classroom() {
	}

//	public Classroom(int id, String rName, Address address) {
//		this.id = id;
//		this.rName = rName;
//		this.address = address;
//	}

	 public int getId() {
	 return id;
	 }
	
	 public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public void setId(int id) {
	 this.id = id;
	 }
	
	 public String getrName() {
	 return rName;
	 }
	
	 public void setrName(String rName) {
	 this.rName = rName;
	 }
	
	 public Address getAddress() {
	 return address;
	 }
	
	 public void setAddress(Address address) {
	 this.address = address;
	 }
}
