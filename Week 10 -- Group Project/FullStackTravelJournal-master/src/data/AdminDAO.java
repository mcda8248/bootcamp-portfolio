package data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import Entities.Location;
import Entities.Trip;
import Entities.User;
import controller.LoginController;

@Transactional
public class AdminDAO
{

	@PersistenceContext
	private EntityManager em;
	LoginDAO loginDAO = new LoginDAO();

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

	
	public void updateUser (User user)
	{
		user = em.merge(user);		
	}
	
	public void removeUser (User user)
	{
		user = em.merge(user);		
		em.remove(user);	
	}
}
