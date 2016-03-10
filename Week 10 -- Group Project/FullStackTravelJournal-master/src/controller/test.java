package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
		
		String videoSrc = "ww.dsfasdf/watch?v=5a7L71jsC4M ";
		
		if (videoSrc.contains("youtube"))
				{
		String videoparsed =videoSrc.substring(videoSrc.indexOf('=') +1);
		System.out.println(videoparsed);
				}
		else {
			System.out.println(videoSrc);
		}
		
//		
//User Travis = new User("Travis","dsfalf@fladsjf.com","1234");
		
//		User Temp =(User)em.createNamedQuery("User.getUserByName")
//        .setParameter("name", test).setParameter("password", password).getSingleResult();

		
		
		
		
	
	//	System.out.println(Temp.getPassword());
//		Travis.setUsername("TRAVIS");
//		
//		em.getTransaction().begin();
//		em.persist(Travis);
//		em.getTransaction().commit();


		
		
	}

}
