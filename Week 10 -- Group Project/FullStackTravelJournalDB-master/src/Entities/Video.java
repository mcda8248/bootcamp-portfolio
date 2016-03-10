package Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "video")
public class Video
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne(optional = false)
	@JoinColumn(name = "location_id", nullable = false)
	private Location location_id;
	
	private String video_src;
	private String video_text;
	public Video()
	{
		
	}
	public Video(int id, Location location_id, String video_src, String video_text)
	{
		super();
		this.id = id;
		this.location_id = location_id;
		this.video_src = video_src;
		this.video_text = video_text;
	}
	public Video(Location location_id, String video_src, String video_text)
	{
		super();
		this.location_id = location_id;
		this.video_src = video_src;
		this.video_text = video_text;
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
	 * @return the video_src
	 */
	public String getVideo_src()
	{
		return video_src;
	}
	/**
	 * @return the video_text
	 */
	public String getVideo_text()
	{
		return video_text;
	}
	/**
	 * @param location_id the location_id to set
	 */
	public void setLocation_id(Location location_id)
	{
		this.location_id = location_id;
	}
	/**
	 * @param video_src the video_src to set
	 */
	public void setVideo_src(String video_src)
	{
		this.video_src = video_src;
	}
	/**
	 * @param video_text the video_text to set
	 */
	public void setVideo_text(String video_text)
	{
		this.video_text = video_text;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "video [id=" + id + ", location_id=" + location_id + ", video_src=" + video_src + ", video_text="
				+ video_text + "]";
	}
	
	
	
}
