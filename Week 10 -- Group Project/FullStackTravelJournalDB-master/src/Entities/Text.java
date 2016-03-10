package Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "text")
public class Text
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne(optional = false)
	@JoinColumn(name = "location_id", nullable = false)
	private Location location_id;
	private String bigtext;
	
	public Text()
	{
	
	}

	public Text(int id, Location location_id, String bigtext)
	{
	
		this.id = id;
		this.location_id = location_id;
		this.bigtext = bigtext;
	}
	public Text(Location location_id, String bigtext)
	{
		
		this.location_id = location_id;
		this.bigtext = bigtext;
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
	 * @return the bigtext
	 */
	public String getBigtext()
	{
		return bigtext;
	}

	/**
	 * @param location_id the location_id to set
	 */
	public void setLocation_id(Location location_id)
	{
		this.location_id = location_id;
	}

	/**
	 * @param bigtext the bigtext to set
	 */
	public void setBigtext(String bigtext)
	{
		this.bigtext = bigtext;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "text [id=" + id + ", location_id=" + location_id + ", bigtext=" + bigtext + "]";
	}
	
	
	
	
	
	

}
