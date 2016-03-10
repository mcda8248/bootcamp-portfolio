package data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import Entities.Audio;
import Entities.Image;
import Entities.Location;
import Entities.Text;
import Entities.Trip;
import Entities.User;
import Entities.Video;

@Transactional
public class TravelDAO
{
	@PersistenceContext
	private EntityManager em;
	public static User loggedin;

	LoginDAO loginDAO = new LoginDAO();

	public static void setLoggedin(User l)
	{
		loggedin = l;
	}

	public void createNewTrip(User user, String tripName, String dateStarted, String dateEnded)
	{

		System.out.println("In method to create trip");
		Trip newTrip = new Trip(loggedin, tripName, dateStarted, dateEnded);
		System.out.println(newTrip.getId());
		user.addTrip(newTrip);
		em.persist(newTrip);

	}

	public Trip findTripById(int tripID)
	{

		System.out.println("In method to find trip by iD");
		Trip newTrip = (Trip) em.createNamedQuery("Trip.getTripById").setParameter("id", tripID).getSingleResult();
		System.out.println(newTrip.getId());

		return newTrip;

	}

	public Location findLocationById(int locationID)
	{

		System.out.println("In method to find Location by ID");
		Location newLocation = (Location) em.createNamedQuery("Location.getLocationById").setParameter("id", locationID)
				.getSingleResult();
		System.out.println(newLocation.getId());

		return newLocation;

	}

	public void deleteLocationById(Trip trip, int locationID)
	{

		System.out.println("In method to delete Location by ID");

		Location loc = em.find(Location.class, locationID);
		
		trip.removeLocation(loc);
		em.remove(loc);
		
		// em.createNamedQuery("Location.deleteLocationById")
		// .setParameter("id", locationID).executeUpdate();

		//em.refresh(trip);
		
		//System.out.println(trip.getLocations());
		// trip.setLocations(locations);

	}
	
	
	
	public void deleteTripById(User user, int tripID)
	{

		
		System.out.println("In method to delete Location by ID");

		Trip trip = em.find(Trip.class, tripID);
		user.removeTrip(trip);
		em.remove(trip);
	
	}
	

	public Location creatNewLocation(Trip tripId, String locationName, String city, String country, String dateStarted,
			String dateEnded)
	{

		System.out.println("In method to create location");

		// Location loc = new Location (locationName,dateStarted, dateEnded);
		Location loc = new Location(tripId, locationName, city, country, dateStarted, dateEnded);
		
		tripId.addLocation(loc);
		// System.out.println(loc.getId());
	//	Collection<Location> locations = tripId.getLocations();
//		locations.add(loc);
//		loc.setTrip_id(tripId);
//		tripId.setLocations(locations);
		em.persist(loc);
		
		return loc;

	}
	

	
	
	public User refreshUser (User user)
	{
		System.out.println("refereshig users");
	user = em.merge(user); // to make the object managedd
	em.refresh(user); //resfresh object from daabase
		return user;
	}
	
	public void creatNewAudio(Location locationId, String audioSrc, String audioText) {
		Audio newAudio = new Audio(locationId, audioSrc, audioText);
		locationId.addAudio(newAudio);
		
		em.persist(newAudio);
	}
	
	public void creatNewImage(Location locationId, String imgSrc, String imgText) {
		Image images= new Image(locationId, imgSrc, imgText);
		System.out.println("In method in TravelDAO to create new Image " + images);
		locationId.addImages(images);
		em.persist(images);
	}
	
	public void creatNewVideo(Location locationId, String videoSrc, String videoText) {
		Video video= new Video(locationId, videoSrc, videoText);
		locationId.addVideo(video);
		em.persist(video);
	}
	
	public void creatNewText(Location locationId, String textBody) {
		Text text = new Text(locationId,textBody);
		locationId.addText(text);
		em.persist(text);
	}
	
	public void updateLocation (Location loc)
	{
		loc = em.merge(loc);		
	}
	
	public List<User> getALLUser()
	{
		System.out.println("In method to get all Users");

		List<User> allusers = new ArrayList<>();
		try {

	allusers = (List<User>)em.createNamedQuery("User.getALLUSER").getResultList();
		
		System.out.println(" size of all users " +allusers.size());
		}
		
		catch (Exception e)
		
		{
			System.out.println(e);
			allusers = null;
			
			
		}
		
		return allusers;
		
	}
	

}
