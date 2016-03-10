package data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import Entities.Trip;
import Entities.User;

@Transactional
public class LoginDAO {
	@PersistenceContext
	private EntityManager em;
	
	
	//public boolean getUserByUsername(String userName)
	
	public User getUserByUsername(String userName){ 
		
		User Temp;
		
		
		try {
			
			System.out.println("in method to get user based on username and the username is " + userName);	
			
		Temp =(User)em.createNamedQuery("User.getUserByName")
        .setParameter("name", userName).getSingleResult();
		
//		if(Temp.getIs_admin())
//		{
//			
//		Temp =	(adminUser)Temp;
//		}
		System.out.println("username is not nul " + Temp.getUsername() +  " and password is  " + Temp.getPassword());
		}
		catch (Exception e)
		{
			System.out.println("In catch");
			Temp =null;	
		}
		finally {
			System.out.println("In finally");
			
		}	
		return Temp;

	}
	
	public User getUserByPassword(String password){ 
		
		User Temp;
		System.out.println("in method to get user based on password " + password);
		
		try {
			Temp =(User)em.createNamedQuery("User.getUserByPassword")
			        .setParameter("password", password).getSingleResult();
			System.out.println("password is not null " + Temp.getPassword());
		}
		catch (Exception e)
		{
			System.out.println("In catch");
			Temp =null;	
		}
		finally {
			System.out.println("In finally");
			
		}	
		return Temp;
	
	}
	
	public String creatNewUser (String username, String password, String email)
	{
		User Temp;
		System.out.println("In method to create user");
		try 
		{
			Temp =(User)em.createNamedQuery("User.getUserByName")
			        .setParameter("name", username).getSingleResult();
		}
		catch (Exception e)
		{
			Temp =null;

		}
		if(Temp!= null)
		{
			return "Username already in use";
		}
		else 
		{

		boolean isAdmin = false;
		User newUser = new User(username,password, email, isAdmin);
		System.out.println(newUser.getEmail());
		em.persist(newUser);
		
		return null;
		}
		
		
	
	}
	
	
	

}
