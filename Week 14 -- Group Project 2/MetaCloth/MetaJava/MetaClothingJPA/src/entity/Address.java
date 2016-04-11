package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name ="address")
public class Address {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	@Column(name= "streetaddress")
	private String streetAddress;
	private String city;
	@Column(name=" stateabbrev")
	private String stateAbbrev;
	@Column(name="zip")
	private int zipcode;
	@ManyToOne
	@JoinColumn(name="userid")
	@JsonBackReference (value = "userAddress")
	private User user;
	@Column(name="isbilling")
	private boolean isBilling;
	@Column(name="isshipping")
	private boolean isShipping;
	//constructors
	public Address(){
		
	}
	
	public Address( String street, String city, String state, int zip, User user, boolean isBilling, boolean isShipping){ 
		this.streetAddress = street;
		this.city = city;
		this.stateAbbrev = state;
		this.zipcode = zip;
		this.user = user;
		this.isBilling = isBilling;
		this.isShipping = isShipping;
	}
	//getters and setters
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getStreetAddress()
	{
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress)
	{
		this.streetAddress = streetAddress;
	}
	public String getCity()
	{
		return city;
	}
	public void setCity(String city)
	{
		this.city = city;
	}
	public String getStateAbbrev()
	{
		return stateAbbrev;
	}
	public void setStateAbbrev(String stateAbbrev)
	{
		this.stateAbbrev = stateAbbrev;
	}
	public int getZipcode()
	{
		return zipcode;
	}
	public void setZipcode(int zipcode)
	{
		this.zipcode = zipcode;
	}
	public User getUser()
	{
		return user;
	}
	public void setUser(User user)
	{
		this.user = user;
	}
	public boolean isBilling()
	{
		return isBilling;
	}
	public void setIsBilling(boolean isBilling)
	{
		this.isBilling = isBilling;
	}
	public boolean isShipping()
	{
		return isShipping;
	}
	public void setIsShipping(boolean isShipping)
	{
		this.isShipping = isShipping;
	}

	@Override
	public String toString()
	{
		return "Address [id=" + id + ", streetAddress=" + streetAddress + ", city=" + city + ", stateAbbrev="
				+ stateAbbrev + ", zipcode=" + zipcode + ", isBilling=" + isBilling + ", isShipping="
				+ isShipping + "]";
	}
	
}