package Entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "trip")
@NamedQueries(
{ @NamedQuery(name = "Trip.getTripById", query = "select T from Trip T where T.id= :id") })
public class Trip
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", nullable = false)

	private User user_id;
	@OneToMany(mappedBy = "trip_id", cascade = CascadeType.ALL)
	private ArrayList<Location> Locations = new ArrayList<Location>();
	private String trip_name;
	private String date_started;
	private String date_ended;

	public Trip()
	{

	}

	public Trip(User user_id)
	{

		this.user_id = user_id;
	}
	public Trip(int id, User user_id)
	{
		this.id = id;
		this.user_id = user_id;
	}

	public Trip(User user_id, String trip_name, String date_started, String date_ended)
	{
		super();
		this.user_id = user_id;
		this.trip_name = trip_name;
		this.date_started = date_started;
		this.date_ended = date_ended;
	}

	/**
	 * @return the id
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * @return the user_id
	 */
	public User getUser_id()
	{
		return user_id;
	}

	/**
	 * @param user_id
	 *            the user_id to set
	 */
	public void setUser_id(User user_id)
	{
		this.user_id = user_id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */

	/**
	 * @return the trip_name
	 */
	public String getTrip_name()
	{
		return trip_name;
	}

	/**
	 * @return the date_started
	 */
	public String getDate_started()
	{
		return date_started;
	}

	/**
	 * @return the date_ended
	 */
	public String getDate_ended()
	{
		return date_ended;
	}

	/**
	 * @param trip_name
	 *            the trip_name to set
	 */
	public void setTrip_name(String trip_name)
	{
		this.trip_name = trip_name;
	}

	/**
	 * @param date_started
	 *            the date_started to set
	 */
	public void setDate_started(String date_started)
	{
		this.date_started = date_started;
	}

	/**
	 * @param date_ended
	 *            the date_ended to set
	 */
	public void setDate_ended(String date_ended)
	{
		this.date_ended = date_ended;
	}

	/**
	 * @return the locations
	 */
	public ArrayList<Location> getLocations()
	{
		return Locations;
	}

	/**
	 * @param locations
	 *            the locations to set
	 */
	public void setLocations(ArrayList<Location> locations)
	{
		Locations = locations;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Trip [id=" + id + ", user_id=" + user_id + ", Locations=" + Locations + ", trip_name=" + trip_name
				+ ", date_started=" + date_started + ", date_ended=" + date_ended + "]";
	}

	public void addLocation(Location location)
	{
		
		if (!getLocations().contains(location))
		{
			getLocations().add(location);
		}
	}
	public void removeLocation(Location location)
	{
		if (getLocations().contains(location))
		{
			getLocations().remove(location);

		}
	}

}
