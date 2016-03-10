package Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "country_logo")
public class CountryLogo
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne(optional = false)
	@JoinColumn(name = "location_id", nullable = false)
	private Location location_id;
	private String img_src;
	
	public CountryLogo()
	{
		
	}

	public CountryLogo(int id, Location location_id, String img_src)
	{
		
		this.id = id;
		this.location_id = location_id;
		this.img_src = img_src;
	}

	/**
	 * @return the id
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * @return the location_id
	 */
	public Location getLocation_id()
	{
		return location_id;
	}

	/**
	 * @return the img_src
	 */
	public String getImg_src()
	{
		return img_src;
	}

	/**
	 * @param location_id the location_id to set
	 */
	public void setLocation_id(Location location_id)
	{
		this.location_id = location_id;
	}

	/**
	 * @param img_src the img_src to set
	 */
	public void setImg_src(String img_src)
	{
		this.img_src = img_src;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "country_logo [id=" + id + ", location_id=" + location_id + ", img_src=" + img_src + "]";
	}
	
	
	
	
	
	

}
