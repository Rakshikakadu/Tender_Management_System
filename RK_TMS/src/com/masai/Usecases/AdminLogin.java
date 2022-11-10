package com.masai.Usecases;

import java.util.Scanner;

import com.masai.Dao.AdministratorDao;
import com.masai.Dao.AdministratorDaoImpl;

public class AdminLogin {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Admin Username: ");
		String adminUserName = sc.next();
		
		System.out.println("Enter Addmin Password: ");
		String adminPassword = sc.next();
		
		try {
			
			AdministratorDao admin = new AdministratorDaoImpl();
			
			Boolean adminIsPresent = admin.adminLogin(adminUserName, adminPassword);
			
			if(adminIsPresent) {
				
				while(true) {
					System.out.println("Enter 1 to register new vendor");
					System.out.println("Enter 2 to view all vendors");
					System.out.println("Enter 10 to Logout");
					int num = sc.nextInt();
					
					
					
					switch(num) {
					
					case 1 : RegisterVendorDetails.main(null);
							  break;
					case 10 : {System.out.println("Logout Succsfull....");
							return;}
					default : System.out.println("Select valid option");
					
					}
					
				}
				
				
			}
			
			
		} catch (Exception e) {
			e.getMessage();
		}
		System.out.println("Logout Succsfull ****....");
	}

}
