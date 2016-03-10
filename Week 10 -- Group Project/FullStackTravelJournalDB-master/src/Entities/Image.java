package Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "images")
public class Image
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne(optional = false)
	@JoinColumn(name = "location_id", nullable = false)
	private Location location_id;
	private String img_src;
	private String img_text;
	
	public Image()
	{
		
	}

	public Image(int id, Location location_id, String img_src, String img_text)
	{
		super();
		this.id = id;
		this.location_id = location_id;
		this.img_src = img_src;
		this.img_text = img_text;
	}
	public Image(Location location_id, String img_src, String img_text)
	{
		super();
		this.location_id = location_id;
		this.img_src = img_src;
		this.img_text = img_text;
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
	 * @return the img_text
	 */
	public String getImg_text()
	{
		return img_text;
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

	/**
	 * @param img_text the img_text to set
	 */
	public void setImg_text(String img_text)
	{
		this.img_text = img_text;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "images [id=" + id + ", location_id=" + location_id + ", img_src=" + img_src + ", img_text=" + img_text
				+ "]";
	}
	
	
	
	

}
