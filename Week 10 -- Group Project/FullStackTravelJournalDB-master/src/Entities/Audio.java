package Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "audio")
public class Audio
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne(optional = false)
	@JoinColumn(name = "location_id", nullable = false)
	private Location location_id;
	private String audio_src;
	private String audio_text;
	
	public Audio()
	{
		
	}

	public Audio(int id, Location location_id, String audio_src, String audio_text)
	{
		super();
		this.id = id;
		this.location_id = location_id;
		this.audio_src = audio_src;
		this.audio_text = audio_text;
	}
	public Audio(Location location_id, String audio_src, String audio_text)
	{
		super();
		this.location_id = location_id;
		this.audio_src = audio_src;
		this.audio_text = audio_text;
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
	 * @return the audio_src
	 */
	public String getAudio_src()
	{
		return audio_src;
	}

	/**
	 * @return the audio_text
	 */
	public String getAudio_text()
	{
		return audio_text;
	}

	/**
	 * @param location_id the location_id to set
	 */
	public void setLocation_id(Location location_id)
	{
		this.location_id = location_id;
	}

	/**
	 * @param audio_src the audio_src to set
	 */
	public void setAudio_src(String audio_src)
	{
		this.audio_src = audio_src;
	}

	/**
	 * @param audio_text the audio_text to set
	 */
	public void setAudio_text(String audio_text)
	{
		this.audio_text = audio_text;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "audio [id=" + id + ", location_id=" + location_id + ", audio_src=" + audio_src + ", audio_text="
				+ audio_text + "]";
	}
	
	
	

}
