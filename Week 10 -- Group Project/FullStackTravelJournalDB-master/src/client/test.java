package client;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Entities.User;


public class test
{
	
	public static void main(String[] args)
	{
		System.out.println("in main");
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("Travel");
		System.out.println("after Factory");
		EntityManager em = emf.createEntityManager();

		System.out.println("after EM");
		String test ="Travis";
		String password ="1234";
		
		//User Travis = new User("Trasdfis","dsfafsdlf@fladsjf.com","1dfdf4");
		
		
	//User Temp =em.createQuery("INSERT into User u (username,email, password) VALUES (harakara,sff@gmail.com, 1234)", User.class).getSingleResult();
User Temp =(User) em.createNamedQuery("User.getUserByName").setParameter("name", test).getSingleResult();

		
		
		
		
	
		System.out.println(Temp.getPassword());
//		Travis.setUsername("TRAVIS");
////		
//		em.getTransaction().begin();
//		em.persist(Travis);
//		em.getTransaction().commit();


		
		
	}

}
