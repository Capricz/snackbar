package com.zliang.snackbar.myjaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
 @XmlAccessorType(XmlAccessType.FIELD)
public class Address {
	@XmlAttribute(name = "addressId")
	private int addrId;

	private String city;
	private String street;

	public Address() {

	}

	public int getAddrId() {
		return addrId;
	}

	public void setAddrId(int addrId) {
		this.addrId = addrId;
	}

	// public Address(String city, String street) {
	// this.city = city;
	// this.street = street;
	// }

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}
}
