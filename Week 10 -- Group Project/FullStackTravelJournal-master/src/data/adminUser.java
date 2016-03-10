package data;


import Entities.User;


public class adminUser extends User
{
	
	
	public static void adminRemoveUser (User user)
	{
		AdminDAO adminDAO = new AdminDAO();
		adminDAO.removeUser(user);
		
	}

}
