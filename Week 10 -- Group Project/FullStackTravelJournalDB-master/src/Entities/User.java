package Entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@NamedQueries(
{ @NamedQuery(name = "User.getUserByName", query = "select u from User u where u.username= :name"),
		@NamedQuery(name = "User.getUserByPassword", query = "select u from User u where u.password =:password"),
		@NamedQuery(name = "User.getALLUSER", query = "select u from User u") })
public class User
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String username;
	private String email;
	private String password;
	private Boolean is_admin;

	@OneToMany(mappedBy = "user_id", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Trip> Trips = new ArrayList<Trip>();

	public User()
	{

	}
	public User(String username, String password, String email)
	{
		super();

		this.username = username;
		this.email = email;
		this.password = password;
	}
	public User(int id, String username, String password, String email)
	{
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public User(String username, String password, String email, Boolean isAdmin)
	{
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.is_admin = isAdmin;
	}

	/**
	 * @return the id
	 */
	public int getId()
	{
		return id;
	}
	/**
	 * @return the username
	 */
	public String getUsername()
	{
		return username;
	}
	/**
	 * @return the email
	 */
	public String getEmail()
	{
		return email;
	}
	/**
	 * @return the password
	 */
	public String getPassword()
	{
		return password;
	}
	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username)
	{
		this.username = username;
	}
	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email)
	{
		this.email = email;
	}
	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password)
	{
		this.password = password;
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "users [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password + "]";
	}
	/**
	 * @return the trips
	 */
	public List<Trip> getTrips()
	{
		return Trips;
	}
	/**
	 * @param trips
	 *            the trips to set
	 */
	public void setTrips(Trip trips)
	{
		this.Trips.add(trips);
	}
	/**
	 * @return the is_admin
	 */
	public Boolean getIs_admin()
	{
		return is_admin;
	}
	/**
	 * @param is_admin
	 *            the is_admin to set
	 */
	public void setIs_admin(Boolean is_admin)
	{
		this.is_admin = is_admin;
	}
	public void addTrip(Trip trip)
	{
		if (!getTrips().contains(trip))
		{
			getTrips().add(trip);
		}
	}
	public void removeTrip(Trip trip)
	{
		if (getTrips().contains(trip))
		{
			getTrips().remove(trip);

		}
	}

}
